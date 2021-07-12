package maa.back.person.configs.runners;

import maa.back.person.entities.Authority;
import maa.back.person.repositories.AuthorityRepository;
import maa.back.person.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Runner implements CommandLineRunner {

    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Authority> authorities= authorityRepository.saveAll(
                Arrays.asList(
                    new Authority(null,"MANAGE_THING_1"),
                    new Authority(null,"MANAGE_THING_2"),
                    new Authority(null,"MANAGE_THING_3"),
                    new Authority(null,"MANAGE_THING_4"),
                    new Authority(null,"MANAGE_THING_5"),
                    new Authority(null,"MANAGE_THING_6"),
                    new Authority(null,"MANAGE_THING_7"),
                    new Authority(null,"MANAGE_THING_8"),
                    new Authority(null,"MANAGE_THING_9"),
                    new Authority(null,"MANAGE_THING_10")
                )
        );
    }
}
