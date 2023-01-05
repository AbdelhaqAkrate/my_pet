package com.ken.mypet.services.Impl;

import com.ken.mypet.entities.Person;
import com.ken.mypet.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import com.ken.mypet.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    
        public Person findByEmail(String email){
            System.out.println("getting person from service");
            System.out.println("This is The Person with email is : " + personRepository.findByEmail(email));
            return personRepository.findByEmail(email);
        }
        public Person register(Person person){
            System.out.println("registering person from service");
            return personRepository.save(person);
        }
        public  Person findById(long id)
        {
            return personRepository.findById(Integer.parseInt(String.valueOf(id))).get();
        }
}
