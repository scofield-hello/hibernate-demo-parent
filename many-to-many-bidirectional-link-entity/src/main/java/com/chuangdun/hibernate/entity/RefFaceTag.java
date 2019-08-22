package com.chuangdun.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder()
@Where(clause = "deleted=0")
@SQLDelete(sql = "update T_REF_FACE_TAG set deleted = 1 where face_id=? and tag_id=?")
@EqualsAndHashCode
@ToString(callSuper = true, exclude = {"face", "tag"})
@Table(name = "T_REF_FACE_TAG")
@NoArgsConstructor
@AllArgsConstructor
public class RefFaceTag implements Serializable {

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

    @Column(nullable = false, columnDefinition = "int default 0", insertable = false)
    private boolean deleted;

    @Id
    @ManyToOne
    private Face face;

    @Id
    @ManyToOne
    private Tag tag;

}
