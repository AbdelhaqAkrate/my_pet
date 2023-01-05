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
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "age")
    private long age;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personPet;
    @OneToMany(mappedBy = "petOffre")
    private List<Offre> offres;
    @OneToMany(mappedBy = "petImage")
    private List<Image> images;

}
