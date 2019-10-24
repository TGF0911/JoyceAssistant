package br.com.jteam.controle;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/list")
public class ListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	
		String action = request.getParameter("action");
		
		switch (action) {
		case "Listar Disciplina":
			listarDisc(request);
			break;
		case "Listar Conteudo":
			listarCont(request);
		break;
		case "Listar Avaliacao":
			listarAval(request);
			break;
		case "Listar Questao":
			listarQuestao(request);
			break;
		default:
			break;
		}
	
	}
	
	private void listarDisc(HttpServletRequest request) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		DisciplinaBO discBo = new DisciplinaBO();
		try {
			List<Disciplina> disciplina = discBo.pesquisarDisc(codigo);
			request.setAttribute("Disicplina", disciplina);
			request.setAttribute("lista", discBo.pesquisarDisc(codigo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listarCont(HttpServletRequest request) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ConteudoBO contBo = new ConteudoBO();
		try {
			List<Conteudo> conteudo = contBo.buscarConteudo(codigo);
			request.setAttribute("conteudo", conteudo);
			request.setAttribute("lista", contBo.buscarConteudo(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listarAval(HttpServletRequest request) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		AvaliacaoBO avaBo =new AvaliacaoBO();
		try {
			List<Avaliacao> avaliacao = avaBo.pesquisarAvaliacao(codigo);
			request.setAttribute("avalaicao", avaliacao);
			request.setAttribute("lista", avaBo.pesquisarAvaliacao(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listarQuestao(HttpServletRequest request) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		QuestaoBO questBo = new QuestaoBO();
		try {
			List<Questao> questao = questBo.pequisarQuestao(codigo);
			request.setAttribute("questao", questao);
			request.setAttribute("lista", questBo.pequisarQuestao(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
