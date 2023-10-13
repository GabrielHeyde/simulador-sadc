
public class Paciente{

    private String nome;
    private int idade;
    private String prontuario;
    private boolean sintomas;
    private String diagnostico;

    public Paciente(String nome, int idade, String prontuario, boolean sintomas) {
        this.nome = nome;
        this.idade = idade;
        this.prontuario = prontuario;
        this.sintomas = sintomas;
        this.diagnostico = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public boolean isSintomas() {
        return sintomas;
    }

    public void setSintomas(boolean sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

}