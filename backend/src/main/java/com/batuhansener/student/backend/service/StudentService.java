package com.batuhansener.student.backend.service;

import com.batuhansener.student.backend.dto.StudentDto;
import com.batuhansener.student.backend.dto.StudentDtoConverter;
import com.batuhansener.student.backend.exception.StudentNotFoundException;
import com.batuhansener.student.backend.model.Student;
import com.batuhansener.student.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;

    public StudentDto add(Student student) {
        if (studentIsExists(student.getEmail())){
            throw new StudentNotFoundException(student.getEmail()+", student already exists.");
        }
        return studentDtoConverter.convert(studentRepository.save(student));
    }

    public void delete(Long id){
        Student student = getById(id);
        if (!studentIsExists(student.getEmail())){
            throw new StudentNotFoundException("this student could not be found.");
        }
        studentRepository.delete(student);
    }

    public StudentDto update(Student student, Long id){
        return studentDtoConverter.convert(
                studentRepository.findById(id)
                        .map(st-> {
                                    st.setFirstName(student.getFirstName());
                                    st.setLastName(student.getLastName());
                                    st.setEmail(student.getEmail());
                                    st.setDepartment(student.getDepartment());
                        return studentRepository.save(st);
                        }).orElseThrow(()-> new StudentNotFoundException("this student could not be found."))
        );
    }

    public StudentDto getStudentById(Long id){
        return studentDtoConverter.convert(getById(id));
    }

    public List<StudentDto> getAllStudents(){
        return studentRepository.findAll().stream()
                .map(studentDtoConverter::convert).collect(Collectors.toList());
    }

    public boolean studentIsExists(String email){
        return studentRepository.findByEmail(email).isPresent();
    }

    public Student getById(Long id){
        return studentRepository.findById(id).orElseThrow();
    }
}
