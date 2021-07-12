package maa.back.person.configs.mappers;

import maa.back.person.dtos.RelationTypeDto;
import maa.back.person.entities.RelationType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RelationTypeMapper {

    RelationType map(RelationTypeDto relationTypeDto);

    @InheritInverseConfiguration
    RelationTypeDto map(RelationType relationType);
}
