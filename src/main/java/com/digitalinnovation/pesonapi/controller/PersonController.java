package com.digitalinnovation.pesonapi.controller;

import com.digitalinnovation.pesonapi.dto.request.PersonDTO;
import com.digitalinnovation.pesonapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.pesonapi.exception.PersonNotFoundException;
import com.digitalinnovation.pesonapi.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Cria uma nova pessoa",
            description = "endpoint cria uma nova pessoa no banco"
    )
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return this.personService.createPerson(personDTO);
    }

    @Operation(
            summary = "Lista todos",
            description = "endpoint lista todas as pessoas do banco"
    )
    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @Operation(
            summary = "Lista uma pessoa",
            description = "endpoint lista uma pessoa no banco através do seu Id"
    )
    @GetMapping("/{id}")
    public PersonDTO listOne(@PathVariable Long id) throws PersonNotFoundException {
        return this.personService.listOne(id);
    }

    @Operation(
            summary = "Deleta uma pessoa",
            description = "endpoint deleta uma pessoa do banco através do seu Id"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        this.personService.delete(id);
    }

    @Operation(
            summary = "Atualiza uma pessoa",
            description = "endpoint atualiza uma pessoa do banco através do seu Id"
    )
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return this.personService.updateById(id, personDTO);
    }
}
