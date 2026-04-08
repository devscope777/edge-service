package com.example.edge_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.edge_service.security.User;

import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    // @GetMapping("/user")
    // public Mono<User> getUser() {
    // return ReactiveSecurityContextHolder
    // .getContext()
    // .map(SecurityContext::getAuthentication)
    // .map(auth -> (OidcUser) auth.getPrincipal())
    // .map(oidc -> new User(
    // oidc.getPreferredUsername(),
    // oidc.getGivenName(),
    // oidc.getFamilyName(),
    // List.of("employee", "customer")));
    // }

    @GetMapping("/user")
    public Mono<User> getUser(@AuthenticationPrincipal OidcUser oidcUser) {
        log.info("User info requested by: {} ", oidcUser.getGivenName());
        return Mono.just(new User(
                oidcUser.getPreferredUsername(),
                oidcUser.getGivenName(),
                oidcUser.getFamilyName(),
                oidcUser.getClaimAsStringList("roles")));
    }
}
