package maa.back.person.controllers;

import maa.back.person.configs.mappers.RelationTypeMapper;
import maa.back.person.dtos.RelationTypeDto;
import maa.back.person.services.RelationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/types")
@CrossOrigin("*")
public class RelationTypeController {
    @Autowired
    RelationTypeMapper relationTypeMapper;
    @Autowired
    RelationTypeService relationTypeService;

    @PostMapping
    RelationTypeDto createOrUpdate(@RequestBody RelationTypeDto relationTypeDto) {
        return relationTypeMapper.map(relationTypeService.saveOrUpdate(relationTypeMapper.map(relationTypeDto)));
    }

    @GetMapping
    List<RelationTypeDto> findAll() {
        return relationTypeService.findAll().stream().map(e -> relationTypeMapper.map(e)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    RelationTypeDto findById(@PathVariable long id) {
        return relationTypeMapper.map(relationTypeService.findById(id));
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable long id) {
        relationTypeService.delete(id);
    }

}
