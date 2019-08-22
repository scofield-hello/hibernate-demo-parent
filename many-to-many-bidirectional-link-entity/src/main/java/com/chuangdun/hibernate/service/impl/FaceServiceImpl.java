package com.chuangdun.hibernate.service.impl;

import com.chuangdun.hibernate.entity.Face;
import com.chuangdun.hibernate.entity.Tag;
import com.chuangdun.hibernate.repository.FaceRepository;
import com.chuangdun.hibernate.repository.TagRepository;
import com.chuangdun.hibernate.service.FaceService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FaceServiceImpl implements FaceService {

    @Autowired
    private FaceRepository faceRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Face save(Face face) {
        return faceRepository.save(face);
    }

    @Override
    public List<Face> findAll() {
        return faceRepository.findAll();
    }

    @Override
    public void delete(Face face) {
        faceRepository.delete(face);
    }

    @Override
    public void saveCascade() {
        Face face1 = Face.builder()
                .pid("411502199203159491")
                .name("尼克1")
                .mobile("18672778291")
                .build();
        Face face2 = Face.builder()
                .pid("411502199203159492")
                .name("尼克2")
                .mobile("18672778291")
                .build();
        Tag tag1 = Tag.builder().name("A1").build();
        Tag tag2 = Tag.builder().name("A2").build();
        tagRepository.saveAll(Lists.newArrayList(tag1, tag2));
        face1.addTag(tag1);
        face1.addTag(tag2);
        face2.addTag(tag1);
        faceRepository.saveAll(Lists.newArrayList(face1, face2));
    }

    @Override
    public void save() {
        Face face3 = Face.builder()
                .pid("411502199203159493")
                .name("尼克3")
                .mobile("18672778293")
                .build();
        List<Tag> tags = tagRepository.findAll();
        for (Tag tag : tags) {
            face3.addTag(tag);
        }
        faceRepository.save(face3);
    }

    @Override
    public void removeTag() {
        Face face = faceRepository.getOne(2L);
        face.getTags().size();
        //face.removeTag(face.getTags().get(0).getTag());
        //删除face_id所有的关联数据，然后重新插入未被remove的关联项目
        faceRepository.save(face);
    }

    @Override
    public void delete() {
        Face face = faceRepository.getOne(2L);
        faceRepository.delete(face);
    }

    @Override
    public void deleteCascade() {
        Face face = faceRepository.getOne(2L);
        faceRepository.delete(face);
    }
}
