package com.ken.mypet.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Integer id;
    private String comment;
    private String date;
    private String time;
    private Integer person_id;
    private Integer post_id;
    
}
