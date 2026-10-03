package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoEstadoMatriculadoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new AlunoEstadoBuilder()
                .setMatricula("2024020")
                .setNome("Ana")
                .build();
    }

    @Test
    void deveTransicionarParaFormado() {
        assertTrue(aluno.formar());
        assertEquals("Formado", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoFormado);
    }

    @Test
    void deveTransicionarParaTrancado() {
        assertTrue(aluno.trancar());
        assertEquals("Trancado", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoTrancado);
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
    void deveTransicionarParaTransferido() {
        assertTrue(aluno.transferir());
        assertEquals("Transferido", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoTransferido);
    }

    @Test
    void naoDevePermitirReMatricula() {
        assertFalse(aluno.matricular());
        assertEquals("Matriculado", aluno.getNomeEstado());
    }
}
