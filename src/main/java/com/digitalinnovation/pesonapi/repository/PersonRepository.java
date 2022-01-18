package com.digitalinnovation.pesonapi.repository;

import com.digitalinnovation.pesonapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
