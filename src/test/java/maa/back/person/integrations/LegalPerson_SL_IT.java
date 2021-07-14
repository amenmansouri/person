package maa.back.person.integrations;


import maa.back.person.entities.LegalPerson;
import maa.back.person.repositories.LegalPersonRepository;
import maa.back.person.services.impls.LegalPersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LegalPersonServiceImpl.class)
@DisplayName("LegalPersonService _ integration test _ service layer")
public class LegalPerson_SL_IT {
    @MockBean
    private LegalPersonRepository legalPersonRepository;
    @Autowired
    private LegalPersonServiceImpl legalPersonService;

    List<LegalPerson> legalPeople= Arrays.asList(
            new LegalPerson(),
            new LegalPerson(),
            new LegalPerson()
    );
    @BeforeEach
    public void init(){
        when(legalPersonRepository.save(legalPeople.get(0))).thenReturn(legalPeople.get(0));
        when(legalPersonRepository.findById(1L)).thenReturn(Optional.of(legalPeople.get(0)));
        when(legalPersonRepository.findById(3L)).thenReturn(Optional.empty());
        when(legalPersonRepository.findAll()).thenReturn(legalPeople);
    }
    @Test
    public void saveOrUpdate() {
        Assertions.assertEquals(legalPeople.get(0),legalPersonService.saveOrUpdate(legalPeople.get(0)));
    }

    @Test
    public void findById() {
        Assertions.assertEquals(legalPersonService.findById(1l),legalPeople.get(0));
        Assertions.assertThrows(EntityNotFoundException.class,()-> {
            legalPersonService.findById(3L);
        });

    }

    @Test
    public void findAll() {
        Assertions.assertEquals(legalPeople.size(),legalPersonService.findAll().size());
    }

    @Test
    public void delete() {
        legalPersonService.delete(1l);
        verify(legalPersonRepository,times(1)).deleteById(1l);
    }
}
