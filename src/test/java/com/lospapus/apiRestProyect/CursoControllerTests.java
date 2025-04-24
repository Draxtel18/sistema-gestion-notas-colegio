package com.lospapus.apiRestProyect;

import com.lospapus.apiRestProyect.model.Curso;
import com.lospapus.apiRestProyect.service.CursoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(CursoControllerTests.class)
public class CursoControllerTests {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    private CursoService cursoService;

    @Test
    void TestGetCursos() throws Exception{
        List<Curso> cursos = List.of(new Curso(
                1, "Razonamiento Logico", "2025", "5toB"
        ));
        when(cursoService.findAll()).thenReturn(cursos);

        mockMvc.perform(get("api/cursos"))
                .andExpect(status().isOk())
                .andDo(document("get-cursoss"));
    }
}
