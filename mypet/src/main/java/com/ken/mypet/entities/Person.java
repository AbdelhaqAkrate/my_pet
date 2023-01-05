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
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "num_pets")
    private Integer num_pets;
    @OneToMany(mappedBy = "person")
    private List<Post> posts;
    @OneToMany(mappedBy = "personComment")
    private List<Comment> comments;
    @OneToMany(mappedBy = "personPet")
    private List<Pet> pets;
    @OneToMany(mappedBy = "personReplay")
    private List<Replay> replays;
    @OneToMany(mappedBy = "personOffre")
    private List<Offre> offres;


}
