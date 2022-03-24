package com.ti2cc;

import java.util.Scanner;

public class Principal {
	    
	public static void main(String[] args){
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		Prestador prestador = new Prestador(4, 12345678, "EscolaHome", "555-9876", "educa@mail.com", "");

		int opcao;
        try (Scanner entrada = new Scanner(System.in)) {
			do{
				
				System.out.println("\n--- Menu ---");
			    System.out.println("\n1. Listar");
			    System.out.println("2. Inserir");
			    System.out.println("3. Atualizar");
			    System.out.println("4. Excluir");
			    System.out.println("5. Sair");
			    System.out.print("\nOpcao: ");
			    
			    opcao = entrada.nextInt();
			    
			    switch(opcao){
			    case 1:
			    	System.out.println("\n--- Prestadores ---");
			    	
			        Prestador[] prestadores = dao.getPrestadores();		
					for(int i = 0; i < prestadores.length; i++) {
						System.out.println(prestadores[i].toString());
					}
					
			        break;
			        
			    case 2:
					if(dao.inserirPrestador(prestador) == true) {
						System.out.println("\nInserção de: " + prestador.toString());
					}
			        break;
			        
			    case 3:
			    	prestador.setEndereco("Rua Palmeiras, n 24, Bairro Antica");
					dao.atualizarPrestador(prestador);
					System.out.println("\nAtualização de: " + prestador.toString());
			        break;
			        
			    case 4:
			    	dao.excluirPrestador(prestador.getId_prestador());
			    	System.out.println("\nExclusão de: " + prestador.toString());
			        break;
			    
			    case 5:
			    	System.out.println("\nSaindo...");
			        break;
			        
			    default:
			        System.out.println("\nOpção inválida.");
			    }
			} while(opcao != 5);
		}
        
        dao.close();
	}
}