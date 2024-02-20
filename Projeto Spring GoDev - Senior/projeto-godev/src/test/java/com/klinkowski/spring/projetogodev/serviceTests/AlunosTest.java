package com.klinkowski.spring.projetogodev.serviceTests;

import com.klinkowski.spring.projetogodev.repository.AlunosRepository;
import com.klinkowski.spring.projetogodev.service.AlunosService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class AlunosServiceTest {

    @InjectMocks
    private AlunosService alunosService;
    @Mock
    private AlunosRepository alunosRepository;

    @Test
    void testeSaveAluno() {
        Alunos alunos = new Alunos();
        alunos.setNome("Wellington Souza");
        alunos.setCpf("12345678932");
        alunos.setEmail("wellingtongodev@gmail.com");
        Alunos save = alunosService.postAlunos(alunos);
        Assertions.assertThat(alunos).isEqualTo(save);
    }

}