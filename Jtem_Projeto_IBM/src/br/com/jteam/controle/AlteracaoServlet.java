package br.com.jteam.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jteam.beans.Adm;
import br.com.jteam.beans.Aluno;
import br.com.jteam.beans.Conteudo;
import br.com.jteam.beans.Questao;
import br.com.jteam.bo.AdmBO;
import br.com.jteam.bo.AlunoBO;
import br.com.jteam.bo.ConteudoBO;
import br.com.jteam.bo.QuestaoBO;


@WebServlet("/alterar")
public class AlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "Alterar Conteudo":
			Conteudo cont = new Conteudo();
			ConteudoBO contBo = new ConteudoBO();
			try {
				contBo.atualizarDocumento(cont, cont.getDocumento());
			} catch (Exception e) {
				e.printStackTrace();
			};
			break;
		case "Alterar Aluno":
			String novaSenha = request.getParameter("novaSenha");
			Aluno al = new Aluno();
			AlunoBO alBo = new AlunoBO();
			try {
				alBo.atualizarSenha(al.getCodigo(), novaSenha, al);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Alterar Adm":
			String senhaNova = request.getParameter("novaSenha");
			Adm adm = new Adm();
			AdmBO admBo = new AdmBO();
			try {
				admBo.atualizarSenha(adm.getCodigo(), senhaNova, adm);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "Alterar Questao":
			int novoPeso = Integer.parseInt(request.getParameter("novoPeso"));			Questao quest = new Questao();
			QuestaoBO questBo = new QuestaoBO();
			try {
				questBo.atualizarPeso(quest.getCodigo(), novoPeso);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		default:
			break;
		}
	}

}
