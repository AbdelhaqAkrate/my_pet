package com.ken.mypet.dto;

import lombok.Data;

import java.util.List;

@Data
public class ImageDto {
    private Integer id;
    private List<String> urls;
    private Integer pet_id;

}
