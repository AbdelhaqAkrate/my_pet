package com.ken.mypet.services;

import com.ken.mypet.entities.Person;
import com.ken.mypet.request.personReq;
public interface PersonService {
    public Person findByEmail(String email);
    public Person register(Person person);
    public Person findById(long id);
    public Person update(long id, personReq person);
}
