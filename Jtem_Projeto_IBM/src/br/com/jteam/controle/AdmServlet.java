package br.com.jteam.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jteam.beans.Adm;
import br.com.jteam.beans.Avaliacao;
import br.com.jteam.beans.Conteudo;
import br.com.jteam.beans.Disciplina;
import br.com.jteam.beans.Questao;
import br.com.jteam.bo.AdmBO;
import br.com.jteam.bo.AvaliacaoBO;
import br.com.jteam.bo.ConteudoBO;
import br.com.jteam.bo.DisciplinaBO;
import br.com.jteam.bo.QuestaoBO;
import br.com.jteam.dao.DisciplinaDAO;

@WebServlet("/AdmSer")
public class AdmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String retorno = "";
	String msg ="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "cadastrarADM":
			try {
				cadastrarAdm(request, retorno, msg);
				request.setAttribute("msg", msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "CadastrarDisc":
			
			cadastrarDisc(request, retorno, msg);
			request.setAttribute("msg", msg);
			
			break;
		case "CadastrarCont":
			cadastrarCont(request, retorno, msg);
			request.setAttribute("msg",msg);
			
		case "Cadastrar Avaliacacao":
			cadastrarAval(request, retorno, msg);
			request.setAttribute("msg", msg);
			
		case "Cadastrar Questao":
			cadastrarQuest(request, retorno, msg);
			request.setAttribute("msg", msg);
		default:
			break;
		}
				
	}
	private void cadastrarAdm(HttpServletRequest request, String retorno, String msg) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String dataNasc = request.getParameter("dataNasc");
		String certificado = request.getParameter("certificado");
		
		Adm adm = new Adm(codigo, nome, email, senha, dataNasc, "", false, certificado);
		AdmBO admBo = new AdmBO();
		try {
			msg = admBo.cadastrar(adm);
			if(msg.equals("Adm Cadastrado")) {
				retorno = "adm.jsp";
			}else {
				retorno = "cadastroAdm.jsp";
			}
			System.out.println("retorno =" + retorno);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Disciplina cadastrarDisc(HttpServletRequest request, String retorno, String msg) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String dataInicio = request.getParameter("dataInicio");
		String dataTermino = request.getParameter("dataTermio");
		
		Conteudo conteudo = cadastrarCont(request, retorno, msg);
		
		Disciplina disc = new Disciplina(codigo, nome, dataInicio, dataTermino, true, conteudo);
		DisciplinaBO discBO = new DisciplinaBO();
		try {
			msg = discBO.cadastrarDisciplina(disc);
			if(msg.equals("Disciplina Cadastrada")) {
				retorno = "adm.jsp";
			}else {
				retorno = "cadastroDisc.jsp";
			}
			System.out.println("retorno = " + retorno);
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("Deu ruim");
			e.printStackTrace();
		}
		if(retorno.equals("adm.jsp")) {
			return disc;
		}else {
			return new Disciplina();
		}
	}
	private Conteudo cadastrarCont(HttpServletRequest request, String retorno, String msg) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String documento = request.getParameter("documento");
		
		Conteudo cont = new Conteudo(codigo, nome, documento);
		ConteudoBO contBo = new ConteudoBO(); 
		try {
			msg = contBo.cadastrar(cont);
			if(msg.equals("Conteudo Casdatrado")) {
				retorno = "adm.jsp";
			}else {
				retorno = "cadastrarCont.jsp";
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(retorno.equals("adm.jsp")) {
			return cont;
		}else {
			return new Conteudo();
		}
	}
	
	private void cadastrarAval(HttpServletRequest request, String retorno, String msg) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String titulo = request.getParameter("titulo");
		int qtd = Integer.parseInt(request.getParameter("qtd"));
		int cdDisc = Integer.parseInt(request.getParameter("cdDisc"));
		Disciplina disc = buscarDisc(cdDisc);
		Questao quest = null;
		for (int i = 0; i < qtd; i++) {
			quest = cadastrarQuest(request, retorno,  msg);
		}
		
		Avaliacao ava = new Avaliacao(codigo, disc, quest, titulo);
		AvaliacaoBO avaBo = new AvaliacaoBO();
		try {
			msg = avaBo.Novoteste(ava);
			if(msg.equals("Teste Montado")) {
				retorno = "adm.jsp";
			}else {
				retorno = "cadastrarQuestao.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("retorno = " + retorno);
		System.out.println(msg);
	}
	
	private Questao cadastrarQuest(HttpServletRequest request, String retorno, String msg) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String descricao = request.getParameter("descricao");
		String altA = request.getParameter("altA");
		String altB = request.getParameter("altB");
		String altC = request.getParameter("altC");
		String altD = request.getParameter("altD");
		int altCorreta = Integer.parseInt(request.getParameter("altCorreta"));
		int pesoQuest = Integer.parseInt(request.getParameter("pesoQuest"));
		
		Questao quest = new Questao(codigo, descricao, altA, altB, altC, altD, altCorreta, pesoQuest);
		QuestaoBO questBo = new QuestaoBO();
		try {
			msg = questBo.cadastrar(quest);
			if(msg.equals("Questao Cadastrada")) {
				retorno = "adm.jsp";
			}else {
				retorno = "cadastroQuest.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(retorno.equals("adm.jsp")) {
			return quest;
		}else {
			return new Questao();
		}
		
	}
	
	private Disciplina buscarDisc(int cod) {
		Disciplina disc = null;
		try {
			DisciplinaDAO discDAO = new DisciplinaDAO();
			 disc = discDAO.getDisciplina(cod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return disc;
	}
	

}
