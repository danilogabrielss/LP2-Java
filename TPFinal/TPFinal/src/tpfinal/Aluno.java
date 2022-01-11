package tpfinal;

public class Aluno {

	private String nome;
	private int idade;
	private float peso;
	private float altura;
	private String objetivo;
	
	public Aluno(String nome, int idade, float peso, float altura, String objetivo) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
		this.objetivo = objetivo;
	}
	
	public Aluno() {
		nome = "";
		idade = 0;
		peso = 0;
		altura = 0;
		objetivo = "";
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

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
}
