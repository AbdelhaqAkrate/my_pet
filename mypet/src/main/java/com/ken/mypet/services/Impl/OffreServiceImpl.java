package com.ken.mypet.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ken.mypet.entities.Offre;
import com.ken.mypet.repository.OffreRepository;
import com.ken.mypet.services.OffreService;

@Service
public class OffreServiceImpl implements OffreService {
    @Autowired
    private OffreRepository offreRepository;

    public Offre save(Offre offre) {
        return offreRepository.save(offre);
    }
    public Offre findByPersonId(long id)
    {
        return offreRepository.findByPersonId(Integer.parseInt(String.valueOf(id)));
    }
    public List<Offre> findAllByOwnerId(long id)
    {
        return offreRepository.findAllByOwnerId(id);
    }
    
}
