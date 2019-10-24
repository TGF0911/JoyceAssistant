package br.com.jteam.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jteam.beans.Aluno;
import br.com.jteam.bo.AlunoBO;

@WebServlet("/SenhaAlt")
public class ServletSenhaAlterada extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession  session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int usuario= Integer.parseInt(request.getParameter("usuario"));
		String senha = request.getParameter("senha");
		String novaSenha = request.getParameter("novaSenha");
		
		session = request.getSession();
		
		Aluno al = new Aluno();
		al.setCodigo(usuario);
		al.setSenha(senha);
		AlunoBO alBo = new AlunoBO();
		
		try {
			alBo.atualizarSenha(al.getCodigo(), novaSenha, al);
			
		} catch (Exception e) {
			
		}
		
	}

}
