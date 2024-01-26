package com.tietoevry.dto;

public record PersonDTO(Long id, String firstName, String surname, String role, String email, String lastLogin,
                        String createdOn) {
}
