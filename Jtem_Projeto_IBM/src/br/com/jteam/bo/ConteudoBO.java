package br.com.jteam.bo;

import java.util.List;

import br.com.jteam.beans.Conteudo;
import br.com.jteam.dao.ConteudoDAO;

public class ConteudoBO {
	//conteudo não pode ter mesmo codigo
	//não pode ter o mesmo documeto
	//não pode ter mesmo nome
	//não pode haver um conteudo sem uma disciplina.
	
	
	
	
	public String cadastrar(Conteudo cont) throws Exception  {
		ConteudoDAO dao = new ConteudoDAO();
		Conteudo conteudo = dao.getConteudo(cont.getCodigo());
		
		conteudo.setNome(conteudo.getNome().toUpperCase());
		conteudo.setDocumento(conteudo.getDocumento().toUpperCase());
		
		if(conteudo.getCodigo() > 0) {
			return "Esse codigo de conteudo é inválido";
		}
		
		
		dao.addConteudo(cont);
		dao.close();
		
		return "Conteudo cadastrado";
	}
	
	
	public List<Conteudo> buscarConteudo(int cod) throws Exception {
		ConteudoDAO dao = new ConteudoDAO();
		Conteudo Objcont = dao.getConteudo(cod);
		
		return dao.pesquisarCont(Objcont.getCodigo());
	}
	
	public String atualizarDocumento(Conteudo cont, String docuGuardado) throws Exception {
		ConteudoDAO dao = new ConteudoDAO();
		Conteudo Objcont = dao.getConteudo(cont.getCodigo());
		String guardar = Objcont.getDocumento();
		
		dao.updateDocumento(cont.getCodigo(),guardar);
		dao.close();
		return "Documento atualizado";
	}
	
	public String apagarConteudo(Conteudo cont, int cod) throws Exception{
		ConteudoDAO dao = new ConteudoDAO();
		Conteudo objCont = dao.getConteudo(cont.getCodigo());
		
		cod = objCont.getCodigo();
		dao.deleteConteudo(cod);
		dao.close();
		return "Conteudo Apagado";
	}
		
	
}
