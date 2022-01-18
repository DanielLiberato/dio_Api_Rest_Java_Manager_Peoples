package com.digitalinnovation.pesonapi.service;

import com.digitalinnovation.pesonapi.dto.MessageResponseDTO;
import com.digitalinnovation.pesonapi.entity.Person;
import com.digitalinnovation.pesonapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person personSaved = this.personRepository.save(person);
        return MessageResponseDTO.builder().message("criado com id : " + personSaved.getId()).build();
    }
}
