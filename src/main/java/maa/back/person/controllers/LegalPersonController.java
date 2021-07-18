package maa.back.person.controllers;

import maa.back.person.configs.mappers.PersonMapper;
import maa.back.person.dtos.LegalPersonDto;
import maa.back.person.dtos.PersonDto;
import maa.back.person.services.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons/lp")
@CrossOrigin("*")
public class LegalPersonController {
    @Autowired
    PersonMapper personMapper;
    @Autowired
    LegalPersonService legalPersonService;
    @PostMapping
    PersonDto createOrUpdate(@RequestBody LegalPersonDto legalPersonDto){
        return personMapper.map(legalPersonService.saveOrUpdate(personMapper.map(legalPersonDto)));
    }
    @GetMapping
    List<PersonDto> findAll(){
        return legalPersonService.findAll().stream().map(e->personMapper.map(e)).collect(Collectors.toList());
    }
    @GetMapping("{id}")
    PersonDto findById(@PathVariable long id){
        return personMapper.map(legalPersonService.findById(id));
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable long id){
        legalPersonService.delete(id);
    }
}
