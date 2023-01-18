package com.ken.mypet.services;

import java.util.List;

import com.ken.mypet.entities.Replay;

public interface ReplayService {
   
    public List<Replay> findAll();
    public Replay save(Replay replay);
    
}
