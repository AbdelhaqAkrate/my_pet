package com.ken.mypet.dto;

import lombok.Data;

@Data
public class ReplayDto {
    private long id;
    private String replay;
    private String date;
    private String time;
    private long person_id;
    private long comment_id;
    
}
