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
@EqualsAndHashCode(callSuper = true, exclude = "tags")
@ToString(callSuper = true, exclude = "tags")
@Table(name = "T_FACE")
@NoArgsConstructor
@AllArgsConstructor
public class Face extends Base implements Serializable {

    private String pid;
    private String name;
    private String mobile;

    //如果加入CascadeType.REMOVE,则删除Face的时候还会删除Tag,即使Tag还被其他Face关联.
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "T_FACE_TAG", joinColumns = @JoinColumn(name = "face_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getFaces().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getFaces().remove(this);
    }
}
