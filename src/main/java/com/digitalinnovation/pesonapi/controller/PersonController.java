package com.digitalinnovation.pesonapi.controller;

import com.digitalinnovation.pesonapi.dto.MessageResponseDTO;
import com.digitalinnovation.pesonapi.entity.Person;
import com.digitalinnovation.pesonapi.repository.PersonRepository;
import com.digitalinnovation.pesonapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return this.personService.createPerson(person);
    }
}
