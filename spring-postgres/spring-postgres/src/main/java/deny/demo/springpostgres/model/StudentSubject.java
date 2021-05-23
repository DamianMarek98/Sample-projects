package deny.demo.springpostgres.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Student_Subject")
public class StudentSubject {

    @EmbeddedId
    private StudentSubjectId id = new StudentSubjectId();

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("subjectId")
    private Subject subject;

    @Column(name = "grade")
    private Integer grade;

}
