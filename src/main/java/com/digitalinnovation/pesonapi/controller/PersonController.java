package com.digitalinnovation.pesonapi.controller;

import com.digitalinnovation.pesonapi.dto.MessageResponseDTO;
import com.digitalinnovation.pesonapi.entity.Person;
import com.digitalinnovation.pesonapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping()
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person personSaved = this.personRepository.save(person);
        return MessageResponseDTO.builder().message("criado com id : " + personSaved.getId()).build();
    }
}
