package com.ken.mypet.repository;

import com.ken.mypet.entities.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface PersonRepository extends CrudRepository<Person, Integer>{
    @Query("SELECT p FROM Person p WHERE p.email = ?1 AND p.password = ?2")
    public Person login(String email, String password);
    @Query("SELECT p FROM Person p WHERE p.email = ?1")
    public Person findByEmail(String email);
}
