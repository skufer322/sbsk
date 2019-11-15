package com.divae.sk.sbsk.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HttpSecuredController {

    @GetMapping("/secured/admin")
    public String getAdminRoot(final Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "You are now on the root URL of the secured admin area -> role 'ADMIN' needed. Your roles: " + userDetails.getAuthorities();
    }

    @GetMapping("/secured/admin/sub1")
    public String getAdminSubUrl1(){
        return "secured admin area sub url 1";
    }

    @GetMapping("/secured/admin/sub2")
    public String getAdminSubUrl2(){
        return "secured admin area sub url ";
    }

    @GetMapping("/secured/authenticated")
    public String getSecuredRoot(final Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "You are now on the root URL of the secured authenticated area. Just authentication needed. Your roles: " +
                userDetails.getAuthorities();
    }

    @GetMapping("/secured/authenticated/sub")
    public String getSecuredSubUrl1(){
        return "secured authenticated area sub url";
    }

    @GetMapping("/secured/free")
    public String getSecuredFreeAccessArea(final Principal principal){
        String username = "Anonymous User";
        if (principal != null && principal.getName() != null){
            username = principal.getName();
        }
        return "Welcome, " + username + ". You are in the free access area of this website!";
    }
}
