package com.chuangdun.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder()
@Where(clause = "deleted=0")
@SQLDelete(sql = "update T_FACE set deleted = 1 where id=?")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "T_FACE")
@NoArgsConstructor
@AllArgsConstructor
public class Face extends Base implements Serializable {

    private String pid;
    private String name;
    private String mobile;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_FACE_TAG",
            joinColumns = @JoinColumn(name = "face_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();
}
