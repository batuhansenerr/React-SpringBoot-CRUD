package com.batuhansener.student.backend.dto;


import lombok.Builder;

@Builder
public record StudentDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String department
) {
}
