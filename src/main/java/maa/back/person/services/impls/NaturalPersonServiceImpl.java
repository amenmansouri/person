package maa.back.person.services.impls;

import maa.back.person.entities.NaturalPerson;
import maa.back.person.repositories.NaturalPersonRepository;
import maa.back.person.services.NaturalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NaturalPersonServiceImpl implements NaturalPersonService {
    @Autowired
    private NaturalPersonRepository naturalPersonRepository;
    @Override
    public NaturalPerson saveOrUpdate(NaturalPerson person) {
        return naturalPersonRepository.save(person);
    }

    @Override
    public NaturalPerson findById(Long id) {
        return naturalPersonRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<NaturalPerson> findAll() {
        return naturalPersonRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        naturalPersonRepository.deleteById(id);
    }
}
