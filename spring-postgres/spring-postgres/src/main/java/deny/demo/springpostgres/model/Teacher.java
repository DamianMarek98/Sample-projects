package deny.demo.springpostgres.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Teacher")
@Data
public class Teacher extends Person {

    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects = new HashSet<>();
}

