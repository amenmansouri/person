package maa.back.person.units;

import maa.back.person.entities.NaturalPerson;
import maa.back.person.repositories.NaturalPersonRepository;
import maa.back.person.services.impls.NaturalPersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class NaturalPersonUT {
    @Mock
    private NaturalPersonRepository naturalPersonRepository;
    @InjectMocks
    private NaturalPersonServiceImpl naturalPersonService;

    List<NaturalPerson> naturalPeople= Arrays.asList(
            new NaturalPerson(),
            new NaturalPerson(),
            new NaturalPerson()
    );
    @BeforeEach
    public void init(){
        when(naturalPersonRepository.save(naturalPeople.get(0))).thenReturn(naturalPeople.get(0));
        when(naturalPersonRepository.findById(1L)).thenReturn(Optional.of(naturalPeople.get(0)));
        when(naturalPersonRepository.findById(3L)).thenReturn(Optional.empty());
        when(naturalPersonRepository.findAll()).thenReturn(naturalPeople);
    }
    @Test
    public void saveOrUpdate() {
        Assertions.assertEquals(naturalPeople.get(0),naturalPersonService.saveOrUpdate(naturalPeople.get(0)));
    }

    @Test
    public void findById() {
        Assertions.assertEquals(naturalPersonService.findById(1l),naturalPeople.get(0));
        Assertions.assertThrows(EntityNotFoundException.class,()-> {
           naturalPersonService.findById(3L);
        });

    }

    @Test
    public void findAll() {
        Assertions.assertEquals(naturalPeople.size(),naturalPersonService.findAll().size());
    }

    @Test
    public void delete() {
        naturalPersonService.delete(1l);
        verify(naturalPersonRepository,times(1)).deleteById(1l);
    }
}
