package deny.demo.springpostgres.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "name", length = 64)
    protected String name;

    @Column(name = "surname", length = 64)
    protected String surname;

    @Column(name = "birth_date", length = 64)
    protected Date birthDate;

}
