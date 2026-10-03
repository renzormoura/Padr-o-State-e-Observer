package padroescomportamentais.state;

import java.util.Observable;
import java.util.Observer;

public class AlunoObservador implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public AlunoObservador(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public void update(Observable aluno, Object arg) {
        this.ultimaNotificacao = nome + ", estado do aluno alterado para: " + ((Aluno) aluno).getNomeEstado();
    }

}
