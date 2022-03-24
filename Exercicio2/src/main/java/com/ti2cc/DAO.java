package com.ti2cc;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão não efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão não efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirPrestador(Prestador prestador) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO prestador (id_prestador, cpf_cnpj, nome, telefone, email, endereco) "
					       + "VALUES (" + prestador.getId_prestador()+ ", '" + prestador.getCpf_cnpj() + "', '"  
					       + prestador.getNome() + "', '" + prestador.getTelefone() + "', '"
						   + prestador.getEmail() + "', '" + prestador.getEndereco() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarPrestador(Prestador prestador) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE prestador SET id_prestador = '" + prestador.getId_prestador() + "', cpf_cnpj = '"  
				       + prestador.getCpf_cnpj()  + "', nome = '" + prestador.getNome() + "', telefone = '" 
				       + prestador.getTelefone()  + "', email = '" + prestador.getEmail() + "', endereco = '" 
				       + prestador.getEndereco()  + "'"
					   + " WHERE id_prestador = " + prestador.getId_prestador();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirPrestador(int id_prestador) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM prestador WHERE id_prestador = " + id_prestador);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Prestador[] getPrestadores() {
		Prestador[] prestadores = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM prestador");		
	         if(rs.next()){
	             rs.last();
	             prestadores = new Prestador[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                prestadores[i] = new Prestador(rs.getInt("id_prestador"), rs.getInt("cpf_cnpj"), 
	                		                  rs.getString("nome"), rs.getString("telefone"),
	                		                  rs.getString("email"), rs.getString("endereco"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return prestadores;
	}

}