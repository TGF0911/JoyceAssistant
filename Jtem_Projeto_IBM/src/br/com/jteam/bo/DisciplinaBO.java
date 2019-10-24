package br.com.jteam.bo;

import java.util.List;

import br.com.jteam.beans.Disciplina;
import br.com.jteam.beans.Progressao;
import br.com.jteam.dao.DisciplinaDAO;
import br.com.jteam.dao.ProgressaoDAO;

public class DisciplinaBO {
	
	
	//codigo n�o pode ser igual
	//disciplina n�o pode ter o mesmo nome
	//data inicio sempre antes de data termino
	//requisitos funcionais: Progresso, Atividade, Avalia��o.
	
	//padronizar tudo pro Upper case;
	
	public String cadastrarDisciplina(Disciplina dis) throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		Disciplina Objdis = dao.getDisciplina(dis.getCodigo());
		
		if(Objdis.getCodigo() == dis.getCodigo()) {
			return "C�digo invalido";
		}
		
		if(Objdis.getCodigo() > 0) {
			return "Esse j� existe";
		}
		if(Objdis.getNome().indexOf(" ") < 0) {
			return "Nome invalido";
		}
		
		Objdis.setNome(Objdis.getNome().toUpperCase());
		
		dao.addDisciplina(dis);
		dao.close();
		return "Disciplina cadastrada";
	}
	
	/*
	 * public String buscarDis(Disciplina dis) throws Exception { DisciplinaDAO dao
	 * = new DisciplinaDAO(); Disciplina Objdis =
	 * dao.getDisciplina(dis.getCodigo());
	 * 
	 * dao.getDisciplina(Objdis.getCodigo()); return Objdis.getNome(); }
	 */
	
	public String progressao(Progressao pro, Disciplina dis) throws Exception{
		ProgressaoDAO proDao = new ProgressaoDAO();
		Progressao objPro = proDao.getProgressao(pro.getDisciplina().getCodigo());
		
		proDao.addProgressao(objPro);
		
		return"Concluido";
	}
	
	
	public String apagarDisciplina(Disciplina dis) throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		Disciplina objDis = dao.getDisciplina(dis.getCodigo());
		
		dao.deleteDisciplina(objDis.getCodigo());
		dao.close();
		return "Disciplina Apagada";
	}
	
	public List<Disciplina> pesquisarDisc(int cod) throws Exception{
		DisciplinaDAO dao = new DisciplinaDAO();
		Disciplina objDisc = new Disciplina(); 
		
		return dao.pesquisarDisciplina(objDisc.getCodigo());
	}
	
	
	
}
