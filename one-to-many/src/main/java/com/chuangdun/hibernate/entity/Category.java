package com.chuangdun.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder()
@Where(clause = "deleted=0")
@SQLDelete(sql = "update T_CATEGORY set deleted = 1 where id=?")
@EqualsAndHashCode(callSuper = true, of = "name")
@ToString(callSuper = true, exclude = "products")
@Table(name = "T_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Base implements Serializable {

    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private final Set<Product> products = new HashSet<>();
}
