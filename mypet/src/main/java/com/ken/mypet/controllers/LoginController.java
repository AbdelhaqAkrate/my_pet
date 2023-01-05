package com.ken.mypet.controllers;

import java.util.*;

import com.ken.mypet.dto.PersonDto;
import com.ken.mypet.entities.Person;
import com.ken.mypet.services.Impl.PersonServiceImpl;
import org.springframework.security.core.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.ken.mypet.helpers.JwtHelper;
import com.ken.mypet.services.PersonService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private final PersonServiceImpl personService;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtHelper jwtHelper;
    private UserDetails userDetails;
    public PersonService getPersonService() {
        return personService;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody PersonDto personDto) {
        System.out.println("login");
        Person person = new Person();
        person.setEmail(personDto.getEmail());
        person.setPassword(personDto.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(person.getEmail(), person.getPassword()));
            userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtHelper.generateToken(userDetails);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PersonDto personDto) {
        System.out.println("register");
        Person person = new Person();
        person.setEmail(personDto.getEmail());
        person.setPassword(personDto.getPassword());
        person.setName(personDto.getName());
        person.setPhone(personDto.getPhone());
        person.setAddress(personDto.getAddress());
        person.setNum_pets(0);
        
        try {
            personService.register(person);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
        }
    }

}