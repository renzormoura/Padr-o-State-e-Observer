package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoEstadoJubiladoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new AlunoEstadoBuilder()
                .setMatricula("2024060")
                .setNome("Elisa")
                .build();
        aluno.jubilar();
    }

    @Test
    void naoDevePermitirMatricular() {
        assertFalse(aluno.matricular());
        assertEquals("Jubilado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirFormar() {
        assertFalse(aluno.formar());
        assertEquals("Jubilado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTrancar() {
        assertFalse(aluno.trancar());
        assertEquals("Jubilado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirEvadir() {
        assertFalse(aluno.evadir());
        assertEquals("Jubilado", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTransferir() {
        assertFalse(aluno.transferir());
        assertEquals("Jubilado", aluno.getNomeEstado());
    }
}
