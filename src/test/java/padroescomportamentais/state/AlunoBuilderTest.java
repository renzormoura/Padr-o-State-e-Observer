package padroescomportamentais.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoBuilderTest {

    @Test
    void deveLancarExcecaoSemMatricula() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new AlunoEstadoBuilder()
                        .setNome("João")
                        .build()
        );
        assertEquals("Matrícula inválida", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoComMatriculaEmBranco() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new AlunoEstadoBuilder()
                        .setMatricula("   ")
                        .setNome("João")
                        .build()
        );
        assertEquals("Matrícula inválida", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoSemNome() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new AlunoEstadoBuilder()
                        .setMatricula("2024001")
                        .build()
        );
        assertEquals("Nome inválido", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoComNomeEmBranco() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new AlunoEstadoBuilder()
                        .setMatricula("2024001")
                        .setNome("   ")
                        .build()
        );
        assertEquals("Nome inválido", ex.getMessage());
    }

    @Test
    void deveCriarAlunoValido() {
        Aluno aluno = new AlunoEstadoBuilder()
                .setMatricula("2024001")
                .setNome("João")
                .build();

        assertNotNull(aluno);
        assertEquals("2024001", aluno.getMatricula());
        assertEquals("João", aluno.getNome());
        assertEquals("Matriculado", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoMatriculado);
    }

    @Test
    void estadoInicial_deveSerMatriculado() {
        Aluno aluno = new AlunoEstadoBuilder()
                .setMatricula("2024010")
                .setNome("Inicial")
                .build();

        assertEquals("Matriculado", aluno.getNomeEstado());
    }
}
