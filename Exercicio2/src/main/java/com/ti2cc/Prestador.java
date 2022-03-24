package com.ti2cc;

public class Prestador {
	private int id_prestador;
	private int cpf_cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	public Prestador() {
		this.id_prestador = 0;
		this.cpf_cnpj = 0;
		this.nome = "";
		this.telefone = "";
		this.email = "";
		this.endereco = "";
	}
	
	public Prestador(int id_prestador, int cpf_cnpj, String nome, String telefone, String email, String endereco) {
		this.id_prestador = id_prestador;
		this.cpf_cnpj = cpf_cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	public void setId_prestador(int id_prestador) {
		this.id_prestador = id_prestador;
	}

	public void setCpf_cnpj(int cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getId_prestador() {
		return id_prestador;
	}

	public int getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String toString() {
		return "Prestador [ID = " + id_prestador + ", CPF ou CNPJ =" + cpf_cnpj + ", Nome = " + nome + ", Telefone = " + telefone + ", E-mail = " + email + ", Endereço = " + endereco +"]";
	}
	
}
