package service;

import java.io.IOException;

import dao.ProdutoDAO;
import model.Produto;
import spark.Request;
import spark.Response;


public class ProdutoService {

	private ProdutoDAO produtoDAO;

	public ProdutoService() {
		try {
			produtoDAO = new ProdutoDAO("produto.dat");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Object add(Request request, Response response) {
		String nome = request.queryParams("nome");
		String cpf_cnpj = request.queryParams("cpf_cnpj");
		String email = request.queryParams("email");
		String telefone = request.queryParams("telefone");
		String endereco = request.queryParams("endereco");

		int idPrestador = produtoDAO.getMaxId() + 1;

		Produto produto = new Produto(idPrestador, nome, cpf_cnpj, email, telefone, endereco);

		produtoDAO.add(produto);

		response.status(201); // 201 Created
		return idPrestador;
	}

	public Object get(Request request, Response response) {
		int idPrestador = Integer.parseInt(request.params(":idPrestador"));
		
		Produto produto = (Produto) produtoDAO.get(idPrestador);
		
		if (produto != null) {
    	    response.header("Content-Type", "application/xml");
    	    response.header("Content-Encoding", "UTF-8");

            return "<prestador>\n" + 
            		"\t<id>" + produto.getIdPrestador() + "</id>\n" +
            		"\t<nome>" + produto.getNome() + "</nome>\n" +
            		"\t<cpf_cnpj>" + produto.getCpf_cnpj() + "</cpf_cnpj>\n" +
            		"\t<email>" + produto.getEmail() + "</email>\n" +
            		"\t<telefone>" + produto.getTelefone() + "</telefone>\n" +
            		"\t<endereco>" + produto.getEndereco() + "</endereco>\n" +
            		"</prestador>\n";
        } else {
            response.status(404); // 404 Not found
            return "Prestador" + idPrestador + " não encontrado.";
        }

	}

	public Object update(Request request, Response response) {
        int idPrestador = Integer.parseInt(request.params(":idPrestador"));
        
		Produto produto = (Produto) produtoDAO.get(idPrestador);

        if (produto != null) {
        	produto.setNome(request.queryParams("nome"));
        	produto.setCpf_cnpj(request.queryParams("cpf_cnpj"));
        	produto.setEmail(request.queryParams("email"));
        	produto.setTelefone(request.queryParams("telefone"));
        	produto.setEndereco(request.queryParams(""));

        	produtoDAO.update(produto);
        	
            return idPrestador;
        } else {
            response.status(404); // 404 Not found
            return "Produto não encontrado.";
        }

	}

	public Object remove(Request request, Response response) {
        int idPrestador = Integer.parseInt(request.params(":idPrestador"));

        Produto produto = (Produto) produtoDAO.get(idPrestador);

        if (produto != null) {

            produtoDAO.remove(produto);

            response.status(200); // success
        	return idPrestador;
        } else {
            response.status(404); // 404 Not found
            return "Prestador não encontrado.";
        }
	}

	public Object getAll(Request request, Response response) {
		StringBuffer returnValue = new StringBuffer("<prestador type=\"array\">");
		for (Produto produto : produtoDAO.getAll()) {
			returnValue.append("<prestador>\n" + 
				"\t<id>" + produto.getIdPrestador() + "</id>\n" +
				"\t<nome>" + produto.getNome() + "</nome>\n" +
				"\t<cpf_cnpj>" + produto.getCpf_cnpj() + "</cpf_cnpj>\n" +
				"\t<email>" + produto.getEmail() + "</email>\n" +
				"\t<telefone>" + produto.getTelefone() + "</telefone>\n" +
				"\t<endereco>" + produto.getEndereco() + "</endereco>\n" +
				"</prestador>\n");
		}
		returnValue.append("</prestador>");
	    response.header("Content-Type", "application/xml");
	    response.header("Content-Encoding", "UTF-8");
		return returnValue.toString();
	}
}