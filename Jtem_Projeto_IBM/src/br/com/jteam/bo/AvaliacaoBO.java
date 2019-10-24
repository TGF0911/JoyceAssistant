package br.com.jteam.bo;

import java.util.List;

import br.com.jteam.beans.Avaliacao;
import br.com.jteam.beans.Disciplina;
import br.com.jteam.beans.MontarTeste;
import br.com.jteam.beans.Questao;
import br.com.jteam.dao.AvaliacaoDAO;
import br.com.jteam.dao.DisciplinaDAO;
import br.com.jteam.dao.MontarTesteDAO;
import br.com.jteam.dao.QuestaoDAO;

public class AvaliacaoBO {

	
	//ENTREGAVEL DE INPUT
	public String Novoteste(Avaliacao ava) throws Exception {
		AvaliacaoDAO avaDao = new AvaliacaoDAO();
		Avaliacao objAva = avaDao.getAvaliacao(ava.getCodigo());

		if (ava.getCodigo() < 1) {
			return "Código Inválido";
		}

		if (objAva.getCodigo() > 0) {
			return "Avaliação já existe";
		}

		if (objAva.getTitulo().equals(ava.getTitulo())) {
			return "Titulo da Avaliação já cadastrado";
		}

		// Padronização
		ava.setTitulo(ava.getTitulo().toUpperCase());

		// requisitos funcionais
		MontarTesteDAO mTeste = new MontarTesteDAO();
		DisciplinaDAO disDao = new DisciplinaDAO();
		Disciplina dis = disDao.getDisciplina(ava.getDisciplina().getCodigo());
		MontarTeste montar = mTeste.getMontarTeste(dis.getCodigo());
		disDao.close();
		
		if (dis.getCodigo() == 0) {
			return "Disicplina não existe";
		}

		QuestaoDAO questDao = new QuestaoDAO();
		Questao quest = questDao.getQuest(ava.getQuestao().getCodigo());
		QuestaoBO questBo = new QuestaoBO();
		questBo.cadastrar(quest);

		if (quest.getCodigo() < 0) {
			return "Questão Inválida";
		}

		avaDao.addAvaliacao(ava);
		mTeste.addMontarTeste(montar);
		avaDao.close();
		return "Teste montado";
	}

	/*
	 * public String buscarAva(Avaliacao ava) throws Exception { AvaliacaoDAO dao =
	 * new AvaliacaoDAO(); Avaliacao Objava = dao.getAvaliacao(ava.getCodigo());
	 * 
	 * dao.getAvaliacao(Objava.getCodigo()); return Objava.getTitulo(); }
	 */

	public String apagarAva(int cod) throws Exception {
		if (cod < 1) {
			return "Código Inválido";
		}

		AvaliacaoDAO avaDao = new AvaliacaoDAO();
		Avaliacao objAva = avaDao.getAvaliacao(cod);

		if (objAva.getCodigo() > 0) {
			return "Avaliação já existe";
		}
		avaDao.deleteAvaliacao(cod);
		avaDao.close();
		return "Avaliação deletada";
	}

	public String atualizarTitulo(Avaliacao ava, String novoTitulo) throws Exception {
		AvaliacaoDAO avaDao = new AvaliacaoDAO();
		Avaliacao objAva = avaDao.getAvaliacao(ava.getCodigo());
		novoTitulo = objAva.getTitulo();
		avaDao.updateAvaliacao(ava.getCodigo(), novoTitulo);
		return "Titulo Atualizado";
	}

	
	
	//BO DO OUTPUT
	public List<Avaliacao> pesquisarAvaliacao(int cod) throws Exception {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao ava = dao.getAvaliacao(cod);

		return dao.pequisarAvaliacao(ava.getCodigo());

	}

}
