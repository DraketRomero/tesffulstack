package com.testfusllstack.garrido_backend.persistance;

import com.testfusllstack.garrido_backend.entities.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO {
    Person save(Person person);
    List<Person> findAll();
    Optional<Person> findById(Long id);
    void deleteById(Long id);
}

