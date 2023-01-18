package com.ken.mypet.response;

import com.ken.mypet.dto.CommentDto;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Long id;
    private String name;
    private String token;
}
