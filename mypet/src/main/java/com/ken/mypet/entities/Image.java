package com.ken.mypet.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "url")
    private String url;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet petImage;
}
