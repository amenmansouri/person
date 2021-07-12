package maa.back.person.services.impls;

import maa.back.person.entities.Relation;
import maa.back.person.repositories.RelationRepository;
import maa.back.person.services.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class RelationServiceImpl implements RelationService {
    @Autowired
    RelationRepository relationRepository;

    @Override
    public Relation saveOrUpdate(Relation entity) {
        return relationRepository.save(entity);
    }

    @Override
    public Relation findById(Long id) {
        return relationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Collection<Relation> findAll() {
        return relationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        relationRepository.deleteById(id);
    }
}
