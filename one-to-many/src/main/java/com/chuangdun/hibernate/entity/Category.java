package com.chuangdun.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder()
@EqualsAndHashCode(callSuper = true, of = "name")
@ToString(callSuper = true)
@Table(name = "T_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Base implements Serializable {

    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "category",
            fetch = FetchType.EAGER)
    private final Set<Product> products = new HashSet<>();

}
