package com.digitalinnovation.pesonapi.service;

import com.digitalinnovation.pesonapi.dto.request.PersonDTO;
import com.digitalinnovation.pesonapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.pesonapi.entity.Person;
import com.digitalinnovation.pesonapi.mapper.PersonMapper;
import com.digitalinnovation.pesonapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
        //realiza  conversão de DTO para uma entidade e salva a referência
        Person personToSave = this.personMapper.toModel(personDTO);
        // Salva a entidade
        Person personSaved = this.personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("criado com id : " + personSaved.getId()).build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = this.personRepository.findAll();
        return allPeople.stream()
                        .map(this.personMapper::toDTO)
                        .collect(Collectors.toList());
    }
}
