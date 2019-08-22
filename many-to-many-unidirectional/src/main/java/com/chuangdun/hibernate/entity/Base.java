package com.chuangdun.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @author nick
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@MappedSuperclass
@NoArgsConstructor
public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

    @Column(nullable = false, columnDefinition = "int default 0", insertable = false)
    private boolean deleted;
}
