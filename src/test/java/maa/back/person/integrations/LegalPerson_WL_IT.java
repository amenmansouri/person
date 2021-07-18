package maa.back.person.integrations;


import maa.back.person.configs.mappers.PersonMapper;
import maa.back.person.controllers.LegalPersonController;
import maa.back.person.dtos.LegalPersonDto;
import maa.back.person.entities.LegalPerson;
import maa.back.person.services.LegalPersonService;
import maa.back.person.utils.JsonConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LegalPersonController.class)
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("LegalPersonController _ integration test _ web layer")
public class LegalPerson_WL_IT {

        @Autowired
        private MockMvc mvc;
        @MockBean
        PersonMapper personMapper;
        @MockBean
        private LegalPersonService legalPersonService;



        List<LegalPerson> legalPeople= Arrays.asList(
                new LegalPerson(),
                new LegalPerson(),
                new LegalPerson()
        );

    @BeforeEach
    public void init() {
        when(personMapper.map(legalPeople.get(0))).thenReturn(new LegalPersonDto());
        when(legalPersonService.saveOrUpdate(legalPeople.get(0))).thenReturn(legalPeople.get(0));
        when(legalPersonService.findById(1L)).thenReturn(legalPeople.get(0));
        when(legalPersonService.findById(3L)).thenThrow(EntityNotFoundException.class);
        when(legalPersonService.findAll()).thenReturn(legalPeople);
    }

    @Test
    public void createOrUpdate() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/persons/lp")
                .content(JsonConverter.asJsonString(personMapper.map(legalPeople.get(0))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/persons/lp")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/persons/lp/".concat("1"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders
                .get("/persons/lp/".concat("3"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());


    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/persons/lp/".concat("1"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
