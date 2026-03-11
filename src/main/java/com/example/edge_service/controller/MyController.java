package com.example.edge_service.controller;

import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyController {

    record Vehicle(String make, String model, int year) {
    }

    @GetMapping("/cars")
    public ResponseEntity<Flux<Vehicle>> cars() {
        return ResponseEntity.ok(Flux.just(
                new Vehicle("Honda", "Civic", 1998),
                new Vehicle("Toyota", "Camry", 2005),
                new Vehicle("Ford", "Raptor", 2019)));
    }

}
