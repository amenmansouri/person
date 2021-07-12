package maa.back.person.repositories;

import maa.back.person.entities.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relation,Long> {
}
