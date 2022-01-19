package com.digitalinnovation.pesonapi.controller;

import com.digitalinnovation.pesonapi.dto.request.PersonDTO;
import com.digitalinnovation.pesonapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.pesonapi.entity.Person;
import com.digitalinnovation.pesonapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return this.personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }
}
