package com.testfusllstack.garrido_backend.persistance.impl;

import com.testfusllstack.garrido_backend.entities.Person;
import com.testfusllstack.garrido_backend.persistance.IPersonDAO;
import com.testfusllstack.garrido_backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
