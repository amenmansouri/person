package maa.back.person.controllers;

import maa.back.person.configs.mappers.PersonMapper;
import maa.back.person.dtos.NaturalPersonDto;
import maa.back.person.dtos.PersonDto;
import maa.back.person.services.NaturalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons/np")
@CrossOrigin("*")
public class NaturalPersonController {
    @Autowired
    PersonMapper personMapper;
    @Autowired
    NaturalPersonService naturalPersonService;
    @PostMapping
    PersonDto createOrUpdate(@RequestBody NaturalPersonDto legalPersonDto){
        return personMapper.map(naturalPersonService.saveOrUpdate(personMapper.map(legalPersonDto)));
    }
    @GetMapping
    List<NaturalPersonDto> findAll(){
        return naturalPersonService.findAll().stream().map(e->personMapper.map(e)).collect(Collectors.toList());
    }
    @GetMapping("{id}")
    PersonDto findById(@PathVariable long id){
        return personMapper.map(naturalPersonService.findById(id));
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable long id){
        naturalPersonService.delete(id);
    }
}