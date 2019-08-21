package com.chuangdun.hibernate;

import com.chuangdun.hibernate.entity.Face;
import com.chuangdun.hibernate.service.FaceService;
import com.chuangdun.hibernate.service.TagService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManyToManyTest {

    @Autowired
    private FaceService faceService;
    @Autowired
    private TagService tagService;

    @Test
    public void testServiceNotNull() {
        Assert.assertNotNull(faceService);
        Assert.assertNotNull(faceService);
    }
    /*@Test
    public void testSaveTag(){
        Tag tag1 = Tag.builder().name("A1").build();
        Tag tag2 = Tag.builder().name("A2").build();
        tagService.save(tag1);
        tagService.save(tag2);
    }

    @Test
    public void testSaveFace(){
        List<Tag> tags = tagService.findAll();
        Face face1 = Face.builder()
                .pid("411502199203159491")
                .name("尼克1")
                .mobile("18672778291")
                .tags(tags)
                .build();
        Face face2 = Face.builder()
                .pid("411502199203159492")
                .name("尼克2")
                .mobile("18672778291")
                .tags(tags)
                .build();
        faceService.save(face1);
        faceService.save(face2);
    }*/

    @Test
    public void testDeleteFace() {
        List<Face> faces = faceService.findAll();
        Face face = faces.get(0);
        faceService.delete(face);
    }
}
