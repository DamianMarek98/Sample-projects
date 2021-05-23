package deny.demo.springpostgres.mappers;

import deny.demo.springpostgres.dto.PersonDto;
import deny.demo.springpostgres.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mappers {
    public static <T extends Person> PersonDto map(T person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .birthDate(person.getBirthDate())
                .build();
    }
}
