package com.ken.mypet.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ken.mypet.dto.ReplayDto;
import com.ken.mypet.entities.Replay;
import com.ken.mypet.services.Impl.CommentServiceImpl;
import com.ken.mypet.services.Impl.PersonServiceImpl;
import com.ken.mypet.services.Impl.ReplayServiceImpl;

import lombok.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/replay")
@RequiredArgsConstructor
public class ReplayController {
    @Autowired
    private ReplayServiceImpl replayService;
    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private CommentServiceImpl commentService;
    
    @GetMapping("/all")
    public ResponseEntity<List<ReplayDto>> getAllReplays() {
        List<Replay> replays = replayService.findAll();
        List<ReplayDto> replayDtos = new ArrayList<>();
        for (Replay replay : replays) {
            ReplayDto replayDto = new ReplayDto();
            replayDto.setId(replay.getId());
            replayDto.setReplay(replay.getReplay());
            replayDto.setDate(replay.getDate());
            replayDto.setTime(replay.getTime());
            replayDto.setComment_id(replay.getComment().getId());
            replayDto.setPerson_id(replay.getPersonReplay().getId());
            replayDtos.add(replayDto);
        }
        return new ResponseEntity<>(replayDtos, HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<ReplayDto> addReplay(@RequestBody ReplayDto replayDto) {
        Replay replay = new Replay();
        replay.setReplay(replayDto.getReplay());
        replay.setDate(replayDto.getDate());
        replay.setTime(replayDto.getTime());
        replay.setComment(commentService.findById(replayDto.getComment_id()));
        replay.setPersonReplay(personService.findById(replayDto.getPerson_id()));
        replayService.save(replay);
        System.out.println(replayService.save(replay).getId());
        return new ResponseEntity<>(replayDto, HttpStatus.OK);
    }
    
}
