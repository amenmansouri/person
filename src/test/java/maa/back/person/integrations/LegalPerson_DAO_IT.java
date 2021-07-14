package maa.back.person.integrations;

import maa.back.person.repositories.LegalPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

/**
 * i should integrate test containers to ensure test
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("LegalPersonRepository _ integration test _ dao layer")
public class LegalPerson_DAO_IT {
    @Autowired
    LegalPersonRepository legalPersonRepository;

    @Test
    public void findById() {
        Assertions.assertTrue(legalPersonRepository.findById(10000000L) instanceof Optional);
    }
}
