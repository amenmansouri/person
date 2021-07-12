package maa.back.person.configs.mappers;

import maa.back.person.dtos.RelationDto;
import maa.back.person.entities.Relation;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
@Mapper(componentModel = "spring")
public abstract class  RelationMapper {

    @Autowired
    PersonMapper personMapper;
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "from",expression = "java(personMapper.map(relation.getFrom()))"),
            @Mapping(target = "to",expression = "java(personMapper.map(relation.getTo()))"),
    })
    public abstract RelationDto map(Relation relation);

    @Mappings({
            @Mapping(target = "from",expression = "java(personMapper.map(relationDto.getFrom()))"),
            @Mapping(target = "to",expression = "java(personMapper.map(relationDto.getTo()))"),
    })
     public abstract Relation map(RelationDto relationDto);



}