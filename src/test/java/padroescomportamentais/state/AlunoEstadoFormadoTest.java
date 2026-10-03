package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoEstadoFormadoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new AlunoEstadoBuilder()
                .setMatricula("2024050")
                .setNome("Diego")
                .build();
        aluno.formar();
    }

    @Test
    void naoDevePermitirMatricular() {
        assertFalse(aluno.matricular());
        assertEquals("Formado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTrancar() {
        assertFalse(aluno.trancar());
        assertEquals("Formado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirJubilar() {
        assertFalse(aluno.jubilar());
        assertEquals("Formado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirEvadir() {
        assertFalse(aluno.evadir());
        assertEquals("Formado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTransferir() {
        assertFalse(aluno.transferir());
        assertEquals("Formado", aluno.getNomeEstado());
    }
}
