package deny.demo.springpostgres.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class StudentSubjectId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long studentId;
    private Long subjectId;

    public StudentSubjectId(Long studentId, Long subjectId) {
        super();
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        final var prime = 31;
        var result = 1;
        result = prime * result
                + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result
                + ((subjectId == null) ? 0 : subjectId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentSubjectId other = (StudentSubjectId) obj;
        return Objects.equals(getStudentId(), other.getStudentId()) && Objects.equals(getSubjectId(), other.getSubjectId());
    }
}
