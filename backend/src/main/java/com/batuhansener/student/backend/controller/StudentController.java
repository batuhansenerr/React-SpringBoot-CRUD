package com.batuhansener.student.backend.controller;

import com.batuhansener.student.backend.dto.StudentDto;
import com.batuhansener.student.backend.model.Student;
import com.batuhansener.student.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public StudentDto addStudent(@RequestBody Student student){
        return studentService.add(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public StudentDto updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.update(student, id);
    }

    @GetMapping("/{id}")
    public StudentDto gelStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
