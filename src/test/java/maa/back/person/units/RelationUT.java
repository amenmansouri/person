package maa.back.person.units;

import maa.back.person.entities.Relation;
import maa.back.person.repositories.RelationRepository;
import maa.back.person.services.impls.RelationServiceImpl;
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
public class RelationUT{
        @Mock
        private RelationRepository relationRepository;
        @InjectMocks
        private RelationServiceImpl relationService;

        List<Relation> relations= Arrays.asList(
                new Relation(),
                new Relation(),
                new Relation()
        );
        @BeforeEach
        public void init(){
            when(relationRepository.save(relations.get(0))).thenReturn(relations.get(0));
            when(relationRepository.findById(1L)).thenReturn(Optional.of(relations.get(0)));
            when(relationRepository.findById(3L)).thenReturn(Optional.empty());
            when(relationRepository.findAll()).thenReturn(relations);
        }
        @Test
        public void saveOrUpdate() {
            Assertions.assertEquals(relations.get(0),relationService.saveOrUpdate(relations.get(0)));
        }

        @Test
        public void findById() {
            Assertions.assertEquals(relationService.findById(1l),relations.get(0));
            Assertions.assertThrows(EntityNotFoundException.class,()-> {
                relationService.findById(3L);
            });

        }

        @Test
        public void findAll() {
            Assertions.assertEquals(relations.size(),relationService.findAll().size());
        }

        @Test
        public void delete() {
            relationService.delete(1l);
            verify(relationRepository,times(1)).deleteById(1l);
        }
}

