package com.ken.mypet.response;

import java.util.List;

import com.ken.mypet.dto.CommentDto;
import com.ken.mypet.dto.UserPostDto;
import com.ken.mypet.dto.UserReplaysDto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostsResponse {
    private long id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String name;
    private long person_id;
}
