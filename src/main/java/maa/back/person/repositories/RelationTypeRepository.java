package maa.back.person.repositories;

import maa.back.person.entities.RelationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationTypeRepository extends JpaRepository<RelationType,Long> {
}
