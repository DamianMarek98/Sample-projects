package deny.demo.springpostgres.controllers;

import deny.demo.springpostgres.dto.PersonDto;
import deny.demo.springpostgres.mappers.Mappers;
import deny.demo.springpostgres.repository.StudentRepository;
import deny.demo.springpostgres.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public PersonController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping(value = "teachers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDto>> getAllTeachers() {
        return new ResponseEntity<>(teacherRepository.findAll().stream().map(Mappers::map).collect(Collectors.toList()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDto>> getAllStudents() {
        return new ResponseEntity<>(studentRepository.findAll().stream().map(Mappers::map).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(Mappers.map(studentRepository.getById(id)), HttpStatus.OK);
    }
}
