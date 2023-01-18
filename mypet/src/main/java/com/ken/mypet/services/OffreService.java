package com.ken.mypet.services;

import java.util.List;

import com.ken.mypet.entities.Offre;

public interface OffreService {
    public Offre save(Offre offre);
    public Offre findByPersonId(long id);
    public List<Offre> findAllByOwnerId(long id);
}
