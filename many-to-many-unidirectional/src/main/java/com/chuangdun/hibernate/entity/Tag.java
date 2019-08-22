package com.chuangdun.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Builder()
@Where(clause = "deleted=0")
@SQLDelete(sql = "update T_TAG set deleted = 1 where id=?")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "T_TAG")
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends Base implements Serializable {

    private String name;
}
