package com.chuangdun.hibernate.service.impl;

import com.chuangdun.hibernate.entity.Tag;
import com.chuangdun.hibernate.repository.TagRepository;
import com.chuangdun.hibernate.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.delete(tag);
    }
}
