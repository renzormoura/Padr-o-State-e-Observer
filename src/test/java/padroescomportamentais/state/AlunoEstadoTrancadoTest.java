package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoEstadoTrancadoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new AlunoEstadoBuilder()
                .setMatricula("2024030")
                .setNome("Bruno")
                .build();
        aluno.trancar();
    }

    @Test
    void deveTransicionarParaMatriculado() {
        assertTrue(aluno.matricular());
        assertEquals("Matriculado", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoMatriculado);
    }

    @Test
    void deveTransicionarParaJubilado() {
        assertTrue(aluno.jubilar());
        assertEquals("Jubilado", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoJubilado);
    }

    @Test
    void deveTransicionarParaEvadido() {
        assertTrue(aluno.evadir());
        assertEquals("Evadido", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoEvadido);
    }

    @Test
    void naoDevePermitirFormar() {
        assertFalse(aluno.formar());
        assertEquals("Trancado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTransferir() {
        assertFalse(aluno.transferir());
        assertEquals("Trancado", aluno.getNomeEstado());
    }
}
