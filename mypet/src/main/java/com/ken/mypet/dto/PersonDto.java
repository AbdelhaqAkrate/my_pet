package com.ken.mypet.dto;

import lombok.Data;

@Data
public class PersonDto {
    private Integer id;
    private String phone;
    private String address;
    private String email;
    private String name;
    private String password;
    private Integer num_pets;
    

}
