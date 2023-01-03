package com.ken.mypet.dto;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Data;

@Data
public class PetDto {
    private Integer id;
    private Integer age;
    private String description;
    private String image;
    private Integer person_id;
    private Integer offre_id;
}
