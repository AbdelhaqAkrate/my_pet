package com.ken.mypet.dto;

import lombok.Data;

@Data
public class ReplayDto {
    private Integer id;
    private String replay;
    private String date;
    private String time;
    private Integer person_id;
    private Integer comment_id;
    
}
