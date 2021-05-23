package deny.demo.springpostgres.controllers;

import deny.demo.springpostgres.model.Teacher;
import deny.demo.springpostgres.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherRepository.getById(id);
    }
}
