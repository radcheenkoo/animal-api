package org.animal_api.rest.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CowControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createCow_thenGetName() throws Exception{

        createAnimal("cows","Nessa");

    }

    @Test
    public void feedCow_thanStatusImUsed() throws  Exception{
        String name = "Nessa";

        mockMvc.perform(put("/cows/feed/%s".formatted(name))
        ).andExpect(status().isImUsed());

    }

    // helpers -------------***********-----------------

    private void createAnimal(String path, String name) throws Exception {
        String json = """
            {
                "name": "%s"
            }
            """.formatted(name);

        mockMvc.perform(post("/%s/create".formatted(path.toLowerCase()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(name));
    }

}
