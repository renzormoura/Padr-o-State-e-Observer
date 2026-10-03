package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoEstadoTransferidoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new AlunoEstadoBuilder()
                .setMatricula("2024070")
                .setNome("Fábio")
                .build();
        aluno.transferir();
    }

    @Test
    void naoDevePermitirMatricular() {
        assertFalse(aluno.matricular());
        assertEquals("Transferido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirFormar() {
        assertFalse(aluno.formar());
        assertEquals("Transferido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTrancar() {
        assertFalse(aluno.trancar());
        assertEquals("Transferido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirJubilar() {
        assertFalse(aluno.jubilar());
        assertEquals("Transferido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirEvadir() {
        assertFalse(aluno.evadir());
        assertEquals("Transferido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTransferir() {
        assertFalse(aluno.transferir());
        assertEquals("Transferido", aluno.getNomeEstado());
    }
}
