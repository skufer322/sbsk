package com.divae.sk.sbsk.controller;

import com.divae.sk.sbsk.data.Person;
import com.divae.sk.sbsk.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final PersonService personService;

    @GetMapping("/greeting")
    public String getStandardGreeting(){
        return "Hello World!";
    }

    @GetMapping("greeting/{custom}")
    public String getParameterizedGreeting(@PathVariable final String custom){
        return "Hello, customized greeting: [" + custom + "]";
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }
}
