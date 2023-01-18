package com.ken.mypet.services;

import java.util.List;

import com.ken.mypet.entities.Pet;

public interface PetService {
    public Pet save(Pet pet);
    public Pet findById(long id);
    public List<Pet> findAll();
    
}
