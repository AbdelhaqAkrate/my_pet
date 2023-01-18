package com.ken.mypet.dto;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Data;

@Data
public class PetDto {
    private Integer id;
    private String name;
    private Integer age;
    private String description;
    private Integer person_id;
    private List<String> images;
    private Integer pet_id;
}
