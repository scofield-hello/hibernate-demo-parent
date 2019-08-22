package com.chuangdun.hibernate;

import com.chuangdun.hibernate.service.FaceService;
import com.chuangdun.hibernate.service.TagService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testCascadeSaveFace() {
        faceService.saveCascade();
    }

    /*@Test
    public void testSaveFace(){
        faceService.save();
    }*/

    /*@Test
    public void testFaceRemoveTag() {
        faceService.removeTag();
    }*/

    /*@Test
    public void delete(){
        faceService.delete();
    }*/

}
