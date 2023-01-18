package com.ken.mypet.repository;

import com.ken.mypet.entities.Replay;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplayRepository extends CrudRepository<Replay, Integer>{
    

    public List<Replay> findAll();
    //save
    public Replay save(Replay replay);


}
