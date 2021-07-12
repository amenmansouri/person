package maa.back.person.services.impls;

import maa.back.person.entities.LegalPerson;
import maa.back.person.repositories.LegalPersonRepository;
import maa.back.person.services.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class LegalPersonServiceImpl implements LegalPersonService {
    @Autowired
    private LegalPersonRepository legalPersonRepository;
    @Override
    public LegalPerson saveOrUpdate(LegalPerson person) {
        return legalPersonRepository.save(person);
    }

    @Override
    public LegalPerson findById(Long id) {
        return legalPersonRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Collection<LegalPerson> findAll() {
        return legalPersonRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        legalPersonRepository.deleteById(id);
    }
}
