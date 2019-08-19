package com.chuangdun.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nick
 */
@Data
@Entity
@Builder()
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update T_PRODUCT set deleted = 1 where id = ?")
@EqualsAndHashCode(callSuper = true, of = "name")
@ToString(callSuper = true, exclude = "category")
@Table(name = "T_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base implements Serializable {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
