package com.ken.mypet.dto;

import lombok.Data;

@Data
public class UserPostDto {
    private Integer id;
    private String title;
    private String description;
    private String date;
    private String time;
    private Integer person_id;
    private String name;
    
}
