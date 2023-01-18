package com.ken.mypet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ken.mypet.entities.Offre;

@Repository
public interface OffreRepository extends CrudRepository<Offre, Integer>{
    public Offre save(Offre offre);
    //find by person id
    @Query("SELECT o FROM Offre o WHERE o.personOffre.id = ?1")
    public Offre findByPersonId(long id);
    //find by pet_owner 
    @Query("SELECT o FROM Offre o WHERE o.pet_owner = ?1")
    public List<Offre> findAllByOwnerId(long id);
}
