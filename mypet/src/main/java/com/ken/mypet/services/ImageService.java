package com.ken.mypet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ken.mypet.entities.Image;

public interface ImageService {
    public Image save(Image image);
    public Image findById(long id);
    public List<Image> findByPetId(long id);
}
