package com.batuhansener.student.backend.dto;

import com.batuhansener.student.backend.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoConverter {

    public StudentDto convert(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .department(student.getDepartment())
                .build();
    }
}
