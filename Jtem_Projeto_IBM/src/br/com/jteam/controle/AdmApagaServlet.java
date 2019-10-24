package br.com.jteam.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jteam.beans.Avaliacao;
import br.com.jteam.beans.Conteudo;
import br.com.jteam.beans.Disciplina;
import br.com.jteam.beans.Questao;
import br.com.jteam.bo.AvaliacaoBO;
import br.com.jteam.bo.ConteudoBO;
import br.com.jteam.bo.DisciplinaBO;
import br.com.jteam.bo.QuestaoBO;

@WebServlet("/apagar")
public class AdmApagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "Apagar Disciplina":
			Disciplina disc = new Disciplina();
			DisciplinaBO disBo = new DisciplinaBO();
			try {
				disBo.apagarDisciplina(disc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Apagar Avalaicao":
			Avaliacao ava = new Avaliacao();
			AvaliacaoBO avaBo = new AvaliacaoBO();
			try {
				avaBo.apagarAva(ava.getCodigo());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Apagar Questao":
			Questao quest = new Questao();
			QuestaoBO questBo = new QuestaoBO();
			try {
				questBo.apagarQuest(quest.getCodigo());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "Apagar Conteudo":
			Conteudo cont = new Conteudo();
			ConteudoBO contBo = new ConteudoBO();
			try {
				contBo.apagarConteudo(cont, cont.getCodigo());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
