package maa.back.person.units;

import maa.back.person.entities.RelationType;
import maa.back.person.repositories.RelationTypeRepository;
import maa.back.person.services.impls.RelationTypeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class RelationTypeUT {
    @Mock
    private RelationTypeRepository relationTypeRepository;
    @InjectMocks
    private RelationTypeServiceImpl relationTypeService;

    List<RelationType> relationTypes= Arrays.asList(
            new RelationType(),
            new RelationType(),
            new RelationType()
    );
    @BeforeEach
    public void init(){
        when(relationTypeRepository.save(relationTypes.get(0))).thenReturn(relationTypes.get(0));
        when(relationTypeRepository.findById(1L)).thenReturn(Optional.of(relationTypes.get(0)));
        when(relationTypeRepository.findById(3L)).thenReturn(Optional.empty());
        when(relationTypeRepository.findAll()).thenReturn(relationTypes);
    }
    @Test
    public void saveOrUpdate() {
        Assertions.assertEquals(relationTypes.get(0),relationTypeService.saveOrUpdate(relationTypes.get(0)));
    }

    @Test
    public void findById() {
        Assertions.assertEquals(relationTypeService.findById(1l),relationTypes.get(0));
        Assertions.assertThrows(EntityNotFoundException.class,()-> {
            relationTypeService.findById(3L);
        });

    }

    @Test
    public void findAll() {
        Assertions.assertEquals(relationTypes.size(),relationTypeService.findAll().size());
    }

    @Test
    public void delete() {
        relationTypeService.delete(1l);
        verify(relationTypeRepository,times(1)).deleteById(1l);
    }
}
