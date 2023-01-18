package com.ken.mypet.dto;

import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String comment;
    private String date;
    private String time;
    private long person_id;
    private long post_id;

}
