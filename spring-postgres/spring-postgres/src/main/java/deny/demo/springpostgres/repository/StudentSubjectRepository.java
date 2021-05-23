package deny.demo.springpostgres.repository;

import deny.demo.springpostgres.model.StudentSubject;
import deny.demo.springpostgres.model.StudentSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, StudentSubjectId> {
}
