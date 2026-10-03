package padroescomportamentais.state;

import java.util.Observable;

public class Aluno extends Observable {

    private String nome;
    private String matricula;
    private AlunoEstado estado;

    // Construtor de uso interno — instanciar via AlunoEstadoBuilder
    Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.estado = AlunoEstadoMatriculado.getInstance();
    }

    // ── State ─────────────────────────────────────────────────

    public void setEstado(AlunoEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public boolean matricular() {
        return estado.matricular(this);
    }

    public boolean formar() {
        return estado.formar(this);
    }

    public boolean trancar() {
        return estado.trancar(this);
    }

    public boolean jubilar() {
        return estado.jubilar(this);
    }

    public boolean evadir() {
        return estado.evadir(this);
    }

    public boolean transferir() {
        return estado.transferir(this);
    }

    // ── Getters ───────────────────────────────────────────────

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AlunoEstado getEstado() {
        return estado;
    }

}
