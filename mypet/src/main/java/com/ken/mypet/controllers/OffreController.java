package com.ken.mypet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ken.mypet.dto.OffreDto;
import com.ken.mypet.entities.Offre;
import com.ken.mypet.services.Impl.OffreServiceImpl;
import com.ken.mypet.services.Impl.PersonServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/offre")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OffreController {

    @Autowired
    private OffreServiceImpl offreService;
    @Autowired
    private PersonServiceImpl personService;
    @PostMapping("/add")
    public ResponseEntity<String> addOffre(@RequestBody OffreDto offreDto) {
        Offre offre = new Offre();
        offre.setPrice(offreDto.getPrice());
        offre.setDuration(offreDto.getDuration());
        offre.setPet_owner(offreDto.getPerson_owner());
        offre.setPersonOffre(personService.findById(offreDto.getPerson_id()));

        offreService.save(offre);
        return ResponseEntity.ok("Offre added");
    }
   

}
