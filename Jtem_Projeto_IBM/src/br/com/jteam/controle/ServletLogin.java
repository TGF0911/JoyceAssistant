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

@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String parametro = request.getParameter("acao");
		
		if(parametro.equals("deslogar")) {
		session.invalidate();
		response.sendRedirect("login.jsp");
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int usuario = Integer.parseInt(request.getParameter("usuario"));
		String senha = request.getParameter("senha");
		
		session = request.getSession();
		
		Aluno al = new Aluno();
		al.setCodigo(usuario);
		al.setSenha(senha);
		AlunoBO alunoBo = new AlunoBO(); 
		
		try {
			if(alunoBo.logar(al)) {
				session.setAttribute("usuario", usuario);
				response.sendRedirect("index.jsp");
				
			}else {
				request.setAttribute("msg","Usuário ou senha inválidos");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
