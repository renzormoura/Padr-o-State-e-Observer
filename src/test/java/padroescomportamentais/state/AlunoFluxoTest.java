package padroescomportamentais.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoFluxoTest {

    @Test
    void matriculadoParaFormado() {
        Aluno aluno = criarAluno("2024090", "Leo");
        AlunoObservador obs = new AlunoObservador("Secretaria");
        aluno.addObserver(obs);

        assertTrue(aluno.formar());
        assertEquals("Formado", aluno.getNomeEstado());
        assertEquals("Secretaria, estado do aluno alterado para: Formado",
                obs.getUltimaNotificacao());
    }

    @Test
    void matriculadoTrancadoMatriculadoFormado() {
        Aluno aluno = criarAluno("2024091", "Mila");
        AlunoObservador obs = new AlunoObservador("Secretaria");
        aluno.addObserver(obs);

        aluno.trancar();
        aluno.matricular();
        aluno.formar();

        assertEquals("Formado", aluno.getNomeEstado());
        assertEquals("Secretaria, estado do aluno alterado para: Formado",
                obs.getUltimaNotificacao());
    }

    @Test
    void matriculadoEvadidoJubilado() {
        Aluno aluno = criarAluno("2024092", "Nando");
        AlunoObservador obs = new AlunoObservador("Secretaria");
        aluno.addObserver(obs);

        aluno.evadir();
        assertEquals("Evadido", aluno.getNomeEstado());

        aluno.jubilar();
        assertEquals("Jubilado", aluno.getNomeEstado());
        assertEquals("Secretaria, estado do aluno alterado para: Jubilado",
                obs.getUltimaNotificacao());
    }

    @Test
    void matriculadoTrancadoJubilado() {
        Aluno aluno = criarAluno("2024093", "Olga");

        aluno.trancar();
        assertTrue(aluno.jubilar());
        assertEquals("Jubilado", aluno.getNomeEstado());
    }

    @Test
    void matriculadoTrancadoEvadidoJubilado() {
        Aluno aluno = criarAluno("2024094", "Paulo");

        aluno.trancar();
        aluno.evadir();
        aluno.jubilar();

        assertEquals("Jubilado", aluno.getNomeEstado());
    }

    @Test
    void matriculadoTransferido_estadoFinal() {
        Aluno aluno = criarAluno("2024095", "Quênia");
        AlunoObservador obs = new AlunoObservador("Secretaria");
        aluno.addObserver(obs);

        aluno.transferir();
        assertEquals("Transferido", aluno.getNomeEstado());

        assertFalse(aluno.matricular());
        assertFalse(aluno.formar());
        assertFalse(aluno.trancar());
        assertFalse(aluno.jubilar());
        assertFalse(aluno.evadir());
        assertFalse(aluno.transferir());
        assertEquals("Transferido", aluno.getNomeEstado());
    }

    @Test
    void singleton_estadoMatriculadoEhMesmaInstancia() {
        Aluno a1 = criarAluno("2024100", "Rita");
        Aluno a2 = criarAluno("2024101", "Saulo");

        assertSame(a1.getEstado(), a2.getEstado());
    }

    @Test
    void singleton_estadoFormadoEhMesmaInstancia() {
        Aluno a1 = criarAluno("2024102", "Thais");
        Aluno a2 = criarAluno("2024103", "Ulrico");
        a1.formar();
        a2.formar();

        assertSame(a1.getEstado(), a2.getEstado());
    }

    private Aluno criarAluno(String matricula, String nome) {
        return new AlunoEstadoBuilder()
                .setMatricula(matricula)
                .setNome(nome)
                .build();
    }
}
