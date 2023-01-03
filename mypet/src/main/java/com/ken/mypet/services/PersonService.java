package com.ken.mypet.services;

import com.ken.mypet.entities.Person;

public interface PersonService {
    public Person login(String email, String password);
    public Person findByEmail(String email);
    
}
