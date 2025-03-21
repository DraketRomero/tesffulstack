package com.testfusllstack.garrido_backend.service.impl;

import com.testfusllstack.garrido_backend.entities.Person;
import com.testfusllstack.garrido_backend.persistance.IPersonDAO;
import com.testfusllstack.garrido_backend.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDAO iPersonDAO;

    @Override
    public Person save(Person person) {
        return iPersonDAO.save(person);
    }

    @Override
    public List<Person> findAll() {
        return iPersonDAO.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return iPersonDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iPersonDAO.deleteById(id);
    }
}

