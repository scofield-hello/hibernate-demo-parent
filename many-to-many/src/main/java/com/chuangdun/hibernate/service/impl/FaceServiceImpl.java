package com.chuangdun.hibernate.service.impl;

import com.chuangdun.hibernate.entity.Face;
import com.chuangdun.hibernate.repository.FaceRepository;
import com.chuangdun.hibernate.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FaceServiceImpl implements FaceService {

    @Autowired
    private FaceRepository faceRepository;

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
}
