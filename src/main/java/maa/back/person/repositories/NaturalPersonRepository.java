package maa.back.person.repositories;

import maa.back.person.entities.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaturalPersonRepository extends JpaRepository<NaturalPerson,Long> {
}
