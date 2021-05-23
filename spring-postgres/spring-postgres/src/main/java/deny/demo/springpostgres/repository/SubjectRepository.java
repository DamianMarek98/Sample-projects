package deny.demo.springpostgres.repository;

import deny.demo.springpostgres.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
