package com.testfusllstack.garrido_backend.controllers;

import com.testfusllstack.garrido_backend.controllers.DTO.PersonDTO;
import com.testfusllstack.garrido_backend.entities.Person;
import com.testfusllstack.garrido_backend.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> save(@RequestBody PersonDTO personDTO) throws URISyntaxException {
        if(personDTO.getName().isBlank() ||
                personDTO.getLastname().isBlank() ||
                personDTO.getPosition().isBlank() ||
                personDTO.getSalary().toString().isBlank() ||
                personDTO.getSalary() == null ||
                personDTO.getBirthday().toString().isBlank())
        {
            ApiResponse response = new ApiResponse(false, "Todos los campos son obligatorios", new ArrayList<>());
            return ResponseEntity.badRequest().body(response);
        }

        try {
            Person person = personService.save(
                    Person.builder()
                            .name(personDTO.getName())
                            .lastname(personDTO.getLastname())
                            .birthday(personDTO.getBirthday())
                            .position(personDTO.getPosition())
                            .salary(personDTO.getSalary())
                            .build()
            );

            List<Object> data = new ArrayList<>();
            data.add(person);

            ApiResponse response = new ApiResponse(true, "Persona creada exitosamente", data);
            return ResponseEntity.created(new URI("http://localhost:8080/api/person/create")).body(response);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse(false, "Error al obtener los datos", new ArrayList<>());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        Optional<Person> personOptional = personService.findById(id);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();

            PersonDTO personDTO = PersonDTO.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .lastname(person.getLastname())
                    .birthday(person.getBirthday())
                    .position(person.getPosition())
                    .salary(person.getSalary())
                    .build();

            List<Object> data = new ArrayList<>();
            data.add(personDTO);
            ApiResponse response = new ApiResponse(true, "Persona encontrada", data);
            return ResponseEntity.ok(response);
        }

        ApiResponse response = new ApiResponse(false, "Persona no encontrada", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse> findAll() {
        try {
            List<PersonDTO> personList = personService.findAll()
                    .stream()
                    .map(person -> PersonDTO.builder()
                            .id(person.getId())
                            .name(person.getName())
                            .lastname(person.getLastname())
                            .birthday(person.getBirthday())
                            .position(person.getPosition())
                            .salary(person.getSalary())
                            .build()
                    ).toList();

            List<Object> data = new ArrayList<>();
            data.add(personList);

            ApiResponse response;
            if (!personList.isEmpty()) {
                response = new ApiResponse(true, "Personas encontradas", data);
            } else {
                response = new ApiResponse(true, "No se encontraron personas", new ArrayList<>());
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse(false, "Error al obtener la lista de personas", new ArrayList<>());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Optional<Person> personOptional = personService.findById(id);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();

            person.setName(personDTO.getName());
            person.setLastname(personDTO.getLastname());
            person.setBirthday(personDTO.getBirthday());
            person.setPosition(personDTO.getPosition());
            person.setSalary(personDTO.getSalary());

            personService.save(person);

            List<Object> data = new ArrayList<>();
            data.add(personDTO);

            ApiResponse response = new ApiResponse(true, "Persona actualizada correctamente", data);
            return ResponseEntity.ok(response);
        }

        ApiResponse response = new ApiResponse(false, "Persona no encontrada", new ArrayList<>());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
        if (id != null) {
            Optional<Person> personOptional = personService.findById(id);
            if(personOptional.isEmpty()) {
                ApiResponse response = new ApiResponse(false, "No existe persona", new ArrayList<>());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            try {
                personService.deleteById(personOptional.get().getId());

                ApiResponse response = new ApiResponse(true, "Persona eliminada correctamente", new ArrayList<>());
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                ApiResponse response = new ApiResponse(false, "Error al eliminar la persona", new ArrayList<>());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }

        ApiResponse response = new ApiResponse(false, "ID no válido", new ArrayList<>());
        return ResponseEntity.badRequest().body(response);
    }
}

