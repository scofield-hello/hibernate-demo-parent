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
@SQLDelete(sql = "update T_TAG set deleted = 1 where id=?")
@EqualsAndHashCode(callSuper = true, exclude = "faces")
@ToString(callSuper = true, exclude = "faces")
@Table(name = "T_TAG")
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends Base implements Serializable {

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "tag", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<RefFaceTag> faces = new ArrayList<>();

}
