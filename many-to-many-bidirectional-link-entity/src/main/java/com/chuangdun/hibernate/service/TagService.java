package com.chuangdun.hibernate.service;

import com.chuangdun.hibernate.entity.Tag;

import java.util.List;

public interface TagService {

    Tag save(Tag tag);

    List<Tag> findAll();

    void delete(Tag tag);
}
