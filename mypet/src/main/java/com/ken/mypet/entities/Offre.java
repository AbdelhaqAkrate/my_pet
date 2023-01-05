package com.ken.mypet.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "offres")
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personOffre;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet petOffre;
    

    
}
