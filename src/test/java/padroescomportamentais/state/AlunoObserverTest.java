package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoObserverTest {

    private Aluno aluno;
    private AlunoObservador obs;

    @BeforeEach
    void setUp() {
        aluno = new AlunoEstadoBuilder()
                .setMatricula("2024080")
                .setNome("Gabi")
                .build();
        obs = new AlunoObservador("Secretaria");
        aluno.addObserver(obs);
    }

    @Test
    void deveNotificarAoTransicionarEstado() {
        aluno.formar();

        assertEquals("Secretaria, estado do aluno alterado para: Formado",
                obs.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMultiplosObservadores() {
        AlunoObservador financeiro = new AlunoObservador("Financeiro");
        aluno.addObserver(financeiro);

        aluno.trancar();

        assertEquals("Secretaria, estado do aluno alterado para: Trancado",
                obs.getUltimaNotificacao());
        assertEquals("Financeiro, estado do aluno alterado para: Trancado",
                financeiro.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarObservadorRemovido() {
        aluno.deleteObserver(obs);

        aluno.formar();

        assertNull(obs.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarEmTransicaoNegada() {
        aluno.formar();

        AlunoObservador obsPos = new AlunoObservador("Financeiro");
        aluno.addObserver(obsPos);

        aluno.trancar();

        assertNull(obsPos.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCadaTransicaoDaSequencia() {
        aluno.trancar();
        assertEquals("Secretaria, estado do aluno alterado para: Trancado",
                obs.getUltimaNotificacao());

        aluno.matricular();
        assertEquals("Secretaria, estado do aluno alterado para: Matriculado",
                obs.getUltimaNotificacao());

        aluno.evadir();
        assertEquals("Secretaria, estado do aluno alterado para: Evadido",
                obs.getUltimaNotificacao());

        aluno.jubilar();
        assertEquals("Secretaria, estado do aluno alterado para: Jubilado",
                obs.getUltimaNotificacao());
    }

    @Test
    void getUltimaNotificacaoDeveSerNullAntesDeQualquerEvento() {
        AlunoObservador novo = new AlunoObservador("Novo");
        assertNull(novo.getUltimaNotificacao());
    }
}
