package com.ken.mypet.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ken.mypet.entities.Image;
import com.ken.mypet.repository.ImageRepository;
import com.ken.mypet.services.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    public Image save(Image image) {
        return imageRepository.save(image);
    }
    public Image findById(long id) {
        return imageRepository.findById(id);
    }
    public List<Image> findByPetId(long id) {
        return imageRepository.findByPetId(id);
    }

    
}
