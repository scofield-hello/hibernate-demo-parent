package com.chuangdun.hibernate.service;

import com.chuangdun.hibernate.entity.Face;

import java.util.List;

public interface FaceService {

    Face save(Face face);

    List<Face> findAll();

    void delete(Face face);
}
