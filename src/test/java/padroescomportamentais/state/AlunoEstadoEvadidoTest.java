package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoEstadoEvadidoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new AlunoEstadoBuilder()
                .setMatricula("2024040")
                .setNome("Carla")
                .build();
        aluno.evadir();
    }

    @Test
    void deveTransicionarParaJubilado() {
        assertTrue(aluno.jubilar());
        assertEquals("Jubilado", aluno.getNomeEstado());
        assertTrue(aluno.getEstado() instanceof AlunoEstadoJubilado);
    }

    @Test
    void naoDevePermitirMatricular() {
        assertFalse(aluno.matricular());
        assertEquals("Evadido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirFormar() {
        assertFalse(aluno.formar());
        assertEquals("Evadido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTrancar() {
        assertFalse(aluno.trancar());
        assertEquals("Evadido", aluno.getNomeEstado());
    }

    @Test
    void naoDevePermitirTransferir() {
        assertFalse(aluno.transferir());
        assertEquals("Evadido", aluno.getNomeEstado());
    }
}
