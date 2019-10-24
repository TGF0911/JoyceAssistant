package br.com.jteam.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jteam.beans.Aluno;
import br.com.jteam.bo.AlunoBO;

@WebServlet("/cadastro")
public class ServletCadastro extends HttpServlet {
private static final long serialVersionUID = -134444248880175521L;
	
	/*
	 * protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	 * ServletException, IOException { } protected void doPost(HttpServletRequest
	 * req, HttpServletResponse resp) throws ServletException, IOException {
	 * 
	 * String codigo = req.getParameter("codigo"); String nome =
	 * req.getParameter("nome"); String senha = req.getParameter("senha"); String
	 * email = req.getParameter("email"); String dataNasc =
	 * req.getParameter("dataNasc"); String datainativ = ""; String curso =
	 * req.getParameter("curso"); String endereco = "Av Lins de Vasconcelos, 1222";
	 * String escolaridade = req.getParameter("escolaridade"); String telefone =
	 * "11-12345678";
	 * 
	 * AlunoBO alunoBO = new AlunoBO();
	 * 
	 * if(codigo.equals("")) { int cod = Integer.parseInt(codigo); Aluno aluno = new
	 * Aluno(cod, nome, senha, email, dataNasc, datainativ, false, curso, endereco,
	 * false, false, escolaridade, telefone); try { alunoBO.cadastrar(aluno); }
	 * catch (Exception e) { e.printStackTrace(); } req.setAttribute("aluno",aluno);
	 * req.setAttribute("msg", "Cliente Cadastrado");
	 * req.getRequestDispatcher("obrigado.jsp").forward(req,resp); } }
	 */

	
	  protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException { doPost(request, response); }
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse
	 response) throws ServletException, IOException { //Receber dados da Pagina
	  int cod = Integer.parseInt(request.getParameter("codigo")); String nome =
	  request.getParameter("nome"); String email = request.getParameter("email");
	  String senha = request.getParameter("senha"); String dataNasc =
	 request.getParameter("dataNasc"); String curso =
	  request.getParameter("curso"); String escolaridade =
	 request.getParameter("escolaridade"); String endereco =
	  request.getParameter("endereco"); String telefone =
	  request.getParameter("telefone");
	  
	  email= email.toUpperCase();
	 
	  //utilizando das minhas classes de negocio BO 
	  Aluno al = new Aluno(cod, nome,
	  email, senha, dataNasc, curso, true, escolaridade, endereco, true, false,
	 telefone, " "); AlunoBO alBo= new AlunoBO ();
	 
	 try {
	 
	 alBo.cadastrar(al); System.out.println("entrou");
	 
	 }catch(Exception e) { e.printStackTrace(); }
	 // Carregando a resposta para página JSP 
	  request.setAttribute("aluno",al);
	  
	  // envia as informações carregadas no request para a página jsp
	 request.getRequestDispatcher("obrigado.jsp").forward(request,response);
	  
	  }
	 

}
