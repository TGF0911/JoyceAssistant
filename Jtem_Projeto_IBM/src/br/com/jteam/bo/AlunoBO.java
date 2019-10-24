package br.com.jteam.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.jteam.beans.Aluno;
import br.com.jteam.dao.AlunoDAO;

public class AlunoBO {
	public String cadastrar(Aluno al) throws Exception {
		AlunoDAO dao = new AlunoDAO();
		
		 Aluno objAl = dao.getAluno(al.getCodigo());
		 
		  
		  if (objAl.getCodigo() > 0) { return "Esse código de usuario já existe!"; }
		 
		  if (objAl.getNome().indexOf(" ") < 0) { return "Nome Inválido"; }
		  
		  
		  if (objAl.getSenha().length() < 7) { return "Senha Inválida"; }
		  
		  if (objAl.getEmail().indexOf("@") < 0) { return "E-mail inválido."; }
		  
		  
		  if (objAl.getEmail().indexOf(".com") < 0) { return "E-mail inválido."; }
		  
		
		 objAl.setNome(objAl.getNome().toUpperCase());
		 objAl.setEmail(objAl.getEmail().toUpperCase());
		 objAl.setEndereco(objAl.getEndereco().toUpperCase());
		 objAl.setCurso(objAl.getCurso().toUpperCase());
		  objAl.setEscolaridade(objAl.getEscolaridade().toUpperCase());
		 

		dao.addAluno(al);
		System.out.println("veio  " + al);
		dao.close();
		return "Usuario Cadastrado";
	}

	//
	public boolean logar(Aluno al) throws Exception {

		AlunoDAO dao = new AlunoDAO();
		Aluno objAl = dao.getAluno(al.getCodigo());
		boolean logar = false;

		if (objAl.getSenha().equals(al.getSenha()) && objAl.getCodigo() == al.getCodigo()) {

			dao.getAluno(objAl.getCodigo());
			return logar = true;
		}
		if (objAl.getCodigo() < 5) {
			return logar == false;
		}
		if (logar) {
			return al.isLogado() == true;
		} else {
			return al.isLogado() == false;
		}

	}

	public String atualizarData(Aluno al, String dataGuardada) throws Exception {
		AlunoDAO dao = new AlunoDAO();
		dataGuardada = guardarData(al);
		dao.updateDataInativa(al.getCodigo(), dataGuardada);
		dao.close();
		return "Data Atualizada";

	}

	public String guardarData(Aluno al) throws Exception {
		if (al.isLogado()) {
			AlunoDAO dao = new AlunoDAO();
			Aluno objAl = dao.getAluno(al.getCodigo());
			DateFormat ultimaData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date data = new Date();
			objAl.setDataInativacao(ultimaData.format(data));
			dao.close();
			return objAl.getDataInativacao();
		} else {
			AlunoDAO dao = new AlunoDAO();
			Aluno objAl = dao.getAluno(al.getCodigo());
			dao.close();
			return objAl.getDataInativacao();
		}

	}

	public String atualizarSenha(int cod, String novaSenha, Aluno al) throws Exception {
		AlunoDAO dao = new AlunoDAO();
		Aluno objAl = dao.getAluno(cod);
		novaSenha = objAl.getSenha();
		if (novaSenha.length() < 7) {
			return "Senha Inválida";
		}
		if (al.getSenha().equals(novaSenha)) {
			return "A senha é a mesma da anterior";
		}
		dao.updatePassword(objAl.getCodigo(), novaSenha);
		dao.close();
		return "Senha Atualizada";
	}

	public String apagarUsuario(Aluno al) throws Exception {
		AlunoDAO dao = new AlunoDAO();
		Aluno objAl = dao.getAluno(al.getCodigo());

		dao.deleteAluno(objAl.getCodigo());
		dao.close();
		return "Usuario Apagado";
	}

}
