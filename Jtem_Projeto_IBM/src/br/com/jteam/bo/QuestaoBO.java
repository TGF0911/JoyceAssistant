package br.com.jteam.bo;

import java.util.List;

import br.com.jteam.beans.Questao;
import br.com.jteam.beans.TesteExecutado;
import br.com.jteam.dao.QuestaoDAO;
import br.com.jteam.dao.TesteExecutadoDAO;

public class QuestaoBO {

	
	public String cadastrar(Questao quest) throws Exception{
		QuestaoDAO dao = new QuestaoDAO();
		Questao objQuest = dao.getQuest(quest.getCodigo());
		
		objQuest.setDescricao(objQuest.getDescricao().toUpperCase());
		objQuest.setAltA(objQuest.getAltA().toUpperCase());
		objQuest.setAltB(objQuest.getAltB().toUpperCase());
		objQuest.setAltC(objQuest.getAltC().toUpperCase());
		objQuest.setAltD(objQuest.getAltD().toUpperCase());
		
		if(objQuest.getCodigo() == quest.getCodigo()){
			return "Essa disciplina já existe";
		}
		if(objQuest.getPesoQuestao() < 0) {
			return "Peso invalido";
		}

		if(objQuest.getAltA().equals(objQuest.getAltB()) || objQuest.getAltA().equals(objQuest.getAltC()) || objQuest.getAltA().equals(objQuest.getAltD())) {
			return "Alternativa já cadstrada";
		}
		if(objQuest.getAltB().equals(objQuest.getAltA()) || objQuest.getAltB().equals(objQuest.getAltC()) || objQuest.getAltB().equals(objQuest.getAltD())) {
			return "Alternativa já cadastrada";
		}
		if(objQuest.getAltC().equals(objQuest.getAltA()) || objQuest.getAltC().equals(objQuest.getAltB()) || objQuest.getAltC().equals(objQuest.getAltD())) {
			return "Alternativa já cadastrada";
		}
		if(objQuest.getAltD().equals(objQuest.getAltA()) || objQuest.getAltD().equals(objQuest.getAltB()) || objQuest.getAltD().equals(objQuest.getAltC())) {
			return "Alternativa já cadastrada";
		}
		
		
		dao.addQuest(quest);
		return "Questao cadastrada";
	}
	
	public String apagarQuest(int cod) throws Exception{
		QuestaoDAO dao = new QuestaoDAO();
		Questao objQuest = dao.getQuest(cod);
		if(objQuest.getCodigo() != cod) {
			return "Questao não existe";
		}
		
		dao.deleteQuest(cod);
		dao.close();
		return "Questao Apagada";
	}
	
	/*
	 * public String buscarQuest(Questao quest) throws Exception { QuestaoDAO dao =
	 * new QuestaoDAO(); Questao Objquest = dao.getQuest(quest.getCodigo());
	 * 
	 * dao.getQuest(Objquest.getCodigo()); return Objquest.getDescricao(); }
	 */
	
	public String testeExecutado(TesteExecutado teste, Questao quest) throws Exception{
		TesteExecutadoDAO testeDao = new TesteExecutadoDAO();
		TesteExecutado objTeste = testeDao.getTesteExecutado(teste.getMontarTeste().getCodigo());
		
		testeDao.addTesteExecutado(objTeste);
		testeDao.close();
		return "Próximo Teste";
	}
	
	
	
	public String atualizarPeso(int cod, int novoPeso) throws Exception{
		QuestaoDAO dao = new QuestaoDAO();
		Questao objQuest = dao.getQuest(cod);
		if(objQuest.getPesoQuestao() < 0) {
			return "Peso invalido";
		}
		
		dao.updatePeso(cod, novoPeso);
		dao.close();
		return "Peso atualizado";
	}
	
	public List<Questao> pequisarQuestao(int cod) throws Exception {
		QuestaoDAO dao = new QuestaoDAO();
		Questao objQuest = dao.getQuest(cod);
		return dao.pesquisarQuestao(objQuest.getCodigo());
	}
	
	
}
