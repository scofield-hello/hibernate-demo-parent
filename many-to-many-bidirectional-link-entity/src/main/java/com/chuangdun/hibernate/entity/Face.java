package com.chuangdun.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @Builder.Default
    @OneToMany(mappedBy = "face", cascade = {CascadeType.ALL},
            orphanRemoval = true)
    private List<RefFaceTag> tags = new ArrayList<>();

    public void addTag(Tag tag) {
        RefFaceTag refFaceTag = RefFaceTag.builder()
                .face(this)
                .tag(tag)
                .build();
        tags.add(refFaceTag);
        tag.getFaces().add(refFaceTag);
    }

    public void removeTag(Tag tag) {
        RefFaceTag refFaceTag = RefFaceTag.builder()
                .face(this)
                .tag(tag)
                .build();
        tag.getFaces().remove(refFaceTag);
        tags.remove(refFaceTag);
        refFaceTag.setTag(null);
        refFaceTag.setFace(null);
    }
}
