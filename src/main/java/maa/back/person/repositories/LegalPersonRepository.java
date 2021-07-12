package maa.back.person.repositories;

import maa.back.person.entities.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalPersonRepository extends JpaRepository<LegalPerson,Long> {
}
