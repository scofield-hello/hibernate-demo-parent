package com.chuangdun.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nick
 */
@Data
@Entity
@Builder()
@EqualsAndHashCode(callSuper = true, of = "name")
@ToString(callSuper = true)
@Table(name = "T_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base implements Serializable {

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
}
