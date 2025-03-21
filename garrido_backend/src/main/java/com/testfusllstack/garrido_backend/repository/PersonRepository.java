package com.testfusllstack.garrido_backend.repository;

import com.testfusllstack.garrido_backend.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}

