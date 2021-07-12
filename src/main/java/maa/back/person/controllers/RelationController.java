package maa.back.person.controllers;

import maa.back.person.configs.mappers.RelationMapper;
import maa.back.person.dtos.RelationDto;
import maa.back.person.services.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/relations")
@CrossOrigin("*")
public class RelationController {
    @Autowired
    RelationMapper relationMapper;
    @Autowired
    RelationService relationService;

    @PostMapping
    RelationDto createOrUpdate(@RequestBody RelationDto relationDto) {
        return relationMapper.map(relationService.saveOrUpdate(relationMapper.map(relationDto)));
    }

    @GetMapping
    List<RelationDto> findAll() {
        return relationService.findAll().stream().map(e -> relationMapper.map(e)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    RelationDto findById(@PathVariable long id) {
        return relationMapper.map(relationService.findById(id));
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable long id) {
        relationService.delete(id);
    }

}
