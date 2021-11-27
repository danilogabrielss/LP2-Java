package pessoa;

public class Pessoa01 {

    static int kp = 0;
    String nome;
    char sexo;
    int idade;

    public Pessoa01(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    public static int getKp() {
        return kp;
    }

    public static void setKp(int kp) {
        Pessoa01.kp = kp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "kp=" + kp + "nome=" + nome + ", sexo=" + sexo + ", idade=" + idade + "}\n";
    }

}
