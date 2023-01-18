package com.ken.mypet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ken.mypet.entities.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer>{
    public Image save(Image image);
    public Image findById(long id);
    //find by pet id
    @Query("SELECT i FROM Image i WHERE i.petImage.id = ?1")
    public List<Image> findByPetId(long id);

}
