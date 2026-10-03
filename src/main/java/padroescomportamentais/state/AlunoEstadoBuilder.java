package padroescomportamentais.state;

public class AlunoEstadoBuilder {

    private String matricula;
    private String nome;

    public AlunoEstadoBuilder setMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public AlunoEstadoBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Aluno build() {
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula inválida");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        return new Aluno(matricula, nome);
    }

}
