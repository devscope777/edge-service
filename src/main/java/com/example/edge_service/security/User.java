package com.example.edge_service.security;

import java.util.List;

public record User(
        String username,
        String firstName,
        String lastName,
        List<String> roles) {
}
