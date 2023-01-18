package com.ken.mypet.controllers;

import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ken.mypet.dto.PetDto;
import com.ken.mypet.entities.Image;
import com.ken.mypet.entities.Pet;
import com.ken.mypet.services.Impl.*;


@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    private PetServiceImpl petService;
    @Autowired
    private ImageServiceImpl imageService;
    @Autowired
    private PersonServiceImpl personService;
    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.findAll();
        return new ResponseEntity<List<Pet>>(pets, HttpStatus.OK);
    }       
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") long id)  {
        Pet pet = petService.findById(id);
        return new ResponseEntity<Pet>(pet, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<PetDto> addPet(@RequestBody PetDto pet) throws Exception {
        // Pet newPet = petService.save(pet);

        String folderPath = "C:\\Breifs\\mypet\\front\\src\\assets\\upload\\";
        Pet p = new Pet();
        p.setName(pet.getName());
        p.setAge(pet.getAge());
        p.setDescription(pet.getDescription());
        p.setPersonPet(personService.findById(pet.getPerson_id()));
        Pet newPet = petService.save(p);


        for(String file : pet.getImages()){
            
            byte[] imageByte = Base64.getDecoder().decode(file);
            System.out.println(imageByte);
            BufferedImage image;
            try{
                image = ImageIO.read(new ByteArrayInputStream(imageByte));
                System.out.println(image);

            } catch (IOException e){
                System.out.println("Error reading image : "+e.getMessage());
                continue;
            }
            
            String formatName;
            String name;
            if (image != null) {
                name = pet.getName() + (int)(Math.random() * 1000);
                formatName = image.getSampleModel().getNumBands() == 3 ? "jpeg" : "png";
                String fileName = name + "." + formatName;
                System.out.println(fileName);
                ImageIO.write(image, formatName, new File(folderPath + fileName));
                Image img = new Image();
                img.setUrl(fileName);
                img.setPetImage(newPet);
                imageService.save(img);

            } else {
                System.out.println("Error reading image : image is null");
                continue;
            }
    }

    return new ResponseEntity<PetDto>(pet, HttpStatus.CREATED);
}
}