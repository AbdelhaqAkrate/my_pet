package com.ken.mypet.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.ken.mypet.entities.Replay;
import com.ken.mypet.repository.ReplayRepository;

import com.ken.mypet.services.ReplayService;
import org.springframework.stereotype.Service;

@Service
public class ReplayServiceImpl implements ReplayService {
    @Autowired
    private ReplayRepository replayRepository;
   
    public List<Replay> findAll() {
        return replayRepository.findAll();
    }
    public Replay save(Replay replay) {
        return replayRepository.save(replay);
    }
    
}
