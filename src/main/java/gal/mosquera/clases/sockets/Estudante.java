package gal.mosquera.clases.sockets;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Estudante implements Serializable {
	private String nome;
	private int idade;
	
	public Estudante(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
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
	
}
