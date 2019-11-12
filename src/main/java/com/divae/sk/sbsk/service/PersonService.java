package com.divae.sk.sbsk.service;

import com.divae.sk.sbsk.data.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {

    public List<Person> getPersons(){
        Person person1 = Person.builder()
                .firstName("Stefan")
                .lastName("Kufer")
                .build();

        Person person2 = Person.builder()
                .firstName("Florence")
                .lastName("Rat")
                .build();

        return List.of(person1, person2);
    }
}
