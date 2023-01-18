package com.ken.mypet.dto;

import lombok.Data;

@Data
public class OffreDto {
    private Integer id;
    private Integer duration;
    private double price;
    private long person_id;
    private long person_owner;
}
