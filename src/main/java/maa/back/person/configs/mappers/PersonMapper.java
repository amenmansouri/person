package maa.back.person.configs.mappers;

import maa.back.person.dtos.LegalPersonDto;
import maa.back.person.dtos.NaturalPersonDto;
import maa.back.person.dtos.PersonDto;
import maa.back.person.entities.LegalPerson;
import maa.back.person.entities.NaturalPerson;
import maa.back.person.entities.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PersonMapper {


        LegalPerson map(LegalPersonDto legalPersonDto);
        @InheritInverseConfiguration
       LegalPersonDto map(LegalPerson legalPerson);

        NaturalPerson map(NaturalPersonDto naturalPersonDto);

        @InheritInverseConfiguration
        @Mapping(ignore = true,target = "password")
         NaturalPersonDto map(NaturalPerson naturalPerson);

        default PersonDto map(Person person) {

            if (person instanceof LegalPerson) {
                return this.map((LegalPerson) person);
            } else if (person instanceof NaturalPerson) {
                return this.map((NaturalPerson) person);
            } else {
                return this.map(person);
            }
        }

        @InheritInverseConfiguration
        default Person map(PersonDto personDto) {
            if (personDto instanceof LegalPersonDto) {
                return this.map((LegalPersonDto) personDto);
            } else if (personDto instanceof NaturalPersonDto) {
                return this.map((NaturalPersonDto) personDto);
            } else {
                return this.map(personDto);
            }
        }


}