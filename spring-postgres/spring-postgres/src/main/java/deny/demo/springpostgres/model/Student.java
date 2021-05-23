package deny.demo.springpostgres.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "Student")
@Data
public class Student extends Person {

    @OneToMany(mappedBy = "student")
    private Set<StudentSubject> studentSubjects = new HashSet<>();

}
