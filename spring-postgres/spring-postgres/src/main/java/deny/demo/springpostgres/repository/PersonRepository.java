package deny.demo.springpostgres.repository;

import deny.demo.springpostgres.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {

}
