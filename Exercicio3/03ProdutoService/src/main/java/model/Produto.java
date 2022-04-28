package model;

import java.io.Serializable;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String PADRAO = "vazio";
	public static final int MAX_ESTOQUE = 1000;
	private int idPrestador;
	private String nome;
	private String cpf_cnpj;
	private String email;
	private String telefone;	
	private String endereco;
	
	public Produto() {
		idPrestador = -1;
		nome = PADRAO;
		cpf_cnpj = PADRAO;
		email = PADRAO;
		telefone = PADRAO;
		endereco = PADRAO;
	}

	public Produto(int idPrestador, String nome, String cpf_cnpj, String email, String telefone, String endereco) {
		setIdPrestador(idPrestador);
		setNome(nome);
		setCpf_cnpj(cpf_cnpj);
		setEmail(email);
		setTelefone(telefone);
		setEndereco(endereco);
	}		
	

	public int getIdPrestador() {
		return idPrestador;
	}

	public void setIdPrestador(int idPrestador) {
		this.idPrestador = idPrestador;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone(){
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco(){
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Nome do prestador: " + nome + "   CPF ou CNPJ" + cpf_cnpj + "   E-mail: " + email +
				"   Telefone: " + telefone  + "   Endereço: " + endereco;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getIdPrestador() == ((Produto) obj).getIdPrestador());
	}	
}