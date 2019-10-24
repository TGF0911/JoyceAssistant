package br.com.jteam.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.jteam.beans.Usuario;
import br.com.jteam.dao.UsuarioDAO;

public class UsuarioBO {

	Usuario objeto = new Usuario();

	public String cadastrar(Usuario usu) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario objUsu = dao.getUser(usu.getCodigo());
		
		objUsu.setNome(objUsu.getNome().toUpperCase());
		objUsu.setEmail(objUsu.getEmail().toUpperCase());

		if (objUsu.getCodigo() > 0) {
			return "Esse código de usuario já existe!";
		}
		if (objUsu.getNome().indexOf(" ") < 0) {
			return "Nome Inválido";
		}
		if (objUsu.getSenha().length() < 7) {
			return "Senha Inválida";
		}
		if (objUsu.getEmail().indexOf("@") < 0) {
			return "E-mail inválido.";
		}
		if (objUsu.getEmail().indexOf(".com") < 0) {
			return "E-mail inválido.";
		}


		dao.addUser(usu);
		dao.close();
		return "Usuario Cadastrado";
	}

	public boolean logar(Usuario usu) throws Exception {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario objUsu = dao.getUser(usu.getCodigo());
		boolean logar = false;

		if (objUsu.getSenha().equals(usu.getSenha()) && objUsu.getCodigo() == usu.getCodigo()) {
			
			dao.getUser(objUsu.getCodigo());
			return logar = true;
		}
		if (objUsu.getCodigo() < 5) {
			return logar == false;
		}
		if (logar) {
			return usu.isLogado() == true;
		} else {
			return usu.isLogado() == false;
		}

	}

	public String atualizarData(Usuario usu, String dataGuardada) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		dataGuardada = guardarData(usu);
		dao.updateDataInativa(usu.getCodigo(), dataGuardada);
		dao.close();
		return "Data Atualizada";

	}

	public String guardarData(Usuario usu) throws Exception {
		if (usu.isLogado()) {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario objUsu = dao.getUser(usu.getCodigo());
			DateFormat ultimaData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date data = new Date();
			 objUsu.setDataInativacao(ultimaData.format(data));
			 dao.close();
			return objUsu.getDataInativacao();
		} else {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario objUsu = dao.getUser(usu.getCodigo());
			dao.close();
			return objUsu.getDataInativacao();
		}

	}
	
	public String atualizarSenha(int cod, String novaSenha, Usuario usu) throws Exception{
		UsuarioDAO dao = new UsuarioDAO();
		Usuario objUsu = dao.getUser(cod);
		novaSenha = objUsu.getSenha();
		if (novaSenha.length() < 7) {
			return "Senha Inválida";
		}	
		if(usu.getSenha().equals(novaSenha)) {
			return "A senha é a mesma da anterior";
		}
		dao.updatePassword(objUsu.getCodigo(), novaSenha);
		dao.close();
		return "Senha Atualizada";
	}
	
	public String apagarUsuario(Usuario usu) throws Exception{
		UsuarioDAO dao = new UsuarioDAO();
		Usuario objUsu = dao.getUser(usu.getCodigo());
		
		dao.deleteUser(objUsu.getCodigo());
		dao.close();
		return "Usuario Apagado";
	}

}
