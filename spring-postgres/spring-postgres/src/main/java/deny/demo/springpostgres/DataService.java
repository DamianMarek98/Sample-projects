package deny.demo.springpostgres;

import deny.demo.springpostgres.model.Student;
import deny.demo.springpostgres.model.StudentSubject;
import deny.demo.springpostgres.model.Subject;
import deny.demo.springpostgres.model.Teacher;
import deny.demo.springpostgres.repository.StudentRepository;
import deny.demo.springpostgres.repository.StudentSubjectRepository;
import deny.demo.springpostgres.repository.SubjectRepository;
import deny.demo.springpostgres.repository.TeacherRepository;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Log4j2
@Component
@NoArgsConstructor
class DataServiceimplements implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    private final SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent applicationReadyEvent) {
        try {
            var geoTeacher = new Teacher();
            geoTeacher.setName("Janusz");
            geoTeacher.setSurname("Grzyb");
            geoTeacher.setBirthDate(simpleDateFormat.parse("31/12/1978"));
            teacherRepository.save(geoTeacher);

            var mathTeacher = new Teacher();
            mathTeacher.setName("Joanna");
            mathTeacher.setSurname("Pi");
            mathTeacher.setBirthDate(simpleDateFormat.parse("31/12/1985"));
            teacherRepository.save(mathTeacher);

            var geo = new Subject();
            geo.setName("Geo");
            geo.setTeacher(geoTeacher);
            subjectRepository.save(geo);

            var math = new Subject();
            math.setName("Math");
            math.setTeacher(mathTeacher);
            subjectRepository.save(math);


            var student = new Student();
            student.setName("Damian");
            student.setSurname("Marek");
            student.setBirthDate(simpleDateFormat.parse("31/12/1998"));
            studentRepository.save(student);

            var student2 = new Student();
            student2.setName("Maciej");
            student2.setSurname("Marek");
            student2.setBirthDate(simpleDateFormat.parse("31/12/2002"));
            studentRepository.save(student2);

            var studentSubject1 = new StudentSubject();
            studentSubject1.setStudent(student);
            studentSubject1.setSubject(geo);
            studentSubject1.setGrade(5);
            studentSubjectRepository.save(studentSubject1);

            var studentSubject3 = new StudentSubject();
            studentSubject3.setStudent(student2);
            studentSubject3.setSubject(geo);
            studentSubject3.setGrade(4);
            studentSubjectRepository.save(studentSubject3);

            var studentSubject2 = new StudentSubject();
            studentSubject2.setStudent(student);
            studentSubject2.setSubject(math);
            studentSubject2.setGrade(6);
            studentSubjectRepository.save(studentSubject2);

        } catch (ParseException e) {
            log.error("Invalid date");
        }
    }

}
