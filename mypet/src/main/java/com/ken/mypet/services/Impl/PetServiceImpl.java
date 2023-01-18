package com.ken.mypet.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ken.mypet.entities.Pet;
import com.ken.mypet.repository.PetRepository;
import com.ken.mypet.services.PetService;
@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }
    public Pet findById(long id) {
        return petRepository.findById(id);
    }
    public List<Pet> findAll() {
        return petRepository.findAll();
    }
}
