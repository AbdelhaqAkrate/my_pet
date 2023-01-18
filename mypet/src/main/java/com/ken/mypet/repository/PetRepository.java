package com.ken.mypet.repository;

import com.ken.mypet.entities.Pet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {
    //save pet and return pet id
    public Pet save(Pet pet);
    public Pet findById(long id);
    public List<Pet> findAll();
}
