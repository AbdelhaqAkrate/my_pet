package com.ken.mypet.services;

import com.ken.mypet.entities.Person;

public interface PersonService {
    public Person findByEmail(String email);
    public Person register(Person person);
    public Person findById(long id);
}
