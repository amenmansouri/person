package maa.back.person.services.impls;

import maa.back.person.entities.RelationType;
import maa.back.person.repositories.RelationTypeRepository;
import maa.back.person.services.RelationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class RelationTypeServiceImpl implements RelationTypeService {
    @Autowired
    private RelationTypeRepository relationTypeRepository;

    @Override
    public RelationType saveOrUpdate(RelationType entity) {
        return relationTypeRepository.save(entity);
    }

    @Override
    public RelationType findById(Long id) {
        return relationTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Collection<RelationType> findAll() {
        return relationTypeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        relationTypeRepository.deleteById(id);
    }
}
