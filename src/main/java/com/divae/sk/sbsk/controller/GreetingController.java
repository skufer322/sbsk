package com.divae.sk.sbsk.controller;

import com.divae.sk.sbsk.data.Person;
import com.divae.sk.sbsk.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final PersonService personService;

    @GetMapping("/greeting")
    public String getStandardGreeting() {
        return "Hello World!";
    }

    @GetMapping("/greeting/{custom}")
    public String getParameterizedGreeting(@PathVariable final String custom) {
        return "Hello, customized greeting: [" + custom + "]";
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/greeting/principal")
    public String getPrincipalGreeting(final Principal principal) {
        String principalName = (principal == null
                ? "Anonymous"
                : principal.getName());
        return "Hello, " + principalName + "!";
    }

    @GetMapping("/greeting/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminGreeting() {
        return "Hello Admin!";
    }

    @GetMapping("/greeting/filtered")
    @PostFilter("filterObject.contains(authentication.name)")
    public List<String> getFilteredGreeting() {
        return Stream.of("Hello user", "Hello Admin", "user, merkel, trump").collect(Collectors.toList());
    }

    @GetMapping("/greeting/userdetails")
    public String getUserRoles(final Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "User " + userDetails.getUsername() + " with password " + userDetails.getPassword() + " has authorities: " + userDetails.getAuthorities();
    }
}
