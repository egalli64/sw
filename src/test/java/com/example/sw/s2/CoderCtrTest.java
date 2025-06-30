package com.example.sw.s2;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CoderCtr.class)
class CoderCtrTest {
    @MockitoBean
    private CoderSvc coderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void codersEmpty() throws Exception {
        List<Coder> coders = List.of();

        // mock the service
        when(coderService.getAll()).thenReturn(coders);

        mockMvc.perform(get("/api/s2/coders")) //
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));

        verify(coderService, times(1)).getAll();
    }

    @Test
    void codersOne() throws Exception {
        List<Coder> coders = List.of(new Coder(103, "Alexander", "Hunold", LocalDate.of(2025, 6, 30), 8500.0));

        // mock the service
        when(coderService.getAll()).thenReturn(coders);

        mockMvc.perform(get("/api/s2/coders")) //
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1))) //
                .andExpect(jsonPath("$[0].id", is(103))) //
                .andExpect(jsonPath("$[0].firstName", is("Alexander"))) //
                .andExpect(jsonPath("$[0].lastName", is("Hunold"))) //
                .andExpect(jsonPath("$[0].hired", is("2025-06-30"))) //
                .andExpect(jsonPath("$[0].salary", is(8500.0)));

        verify(coderService, times(1)).getAll();
    }
}
