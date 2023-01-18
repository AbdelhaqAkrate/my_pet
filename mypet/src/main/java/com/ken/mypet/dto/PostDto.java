package com.ken.mypet.dto;

import lombok.Data;

@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String date;
    private String time;
    private long person_id;
     
}
