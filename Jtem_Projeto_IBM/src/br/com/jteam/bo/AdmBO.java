package br.com.jteam.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.jteam.beans.Adm;
import br.com.jteam.beans.Usuario;
import br.com.jteam.dao.AdmDAO;

public class AdmBO {
	
	public String cadastrar(Adm adm) throws Exception {
		AdmDAO dao = new AdmDAO();
		Adm objAdm = dao.getAdm(adm.getCodigo());
		
		objAdm.setNome(objAdm.getNome().toUpperCase());
		objAdm.setEmail(objAdm.getEmail().toUpperCase());
		objAdm.setCertificado(objAdm.getCertificado().toUpperCase());

		if (objAdm.getCodigo() > 0) {
			return "Esse código de usuario já existe!";
		}
		if (objAdm.getNome().indexOf(" ") < 0) {
			return "Nome Inválido";
		}
		if (objAdm.getSenha().length() < 7) {
			return "Senha Inválida";
		}
		if (objAdm.getEmail().indexOf("@") < 0) {
			return "E-mail inválido.";
		}
		if (objAdm.getEmail().indexOf(".com") < 0) {
			return "E-mail inválido.";
		}


		dao.addAdm(adm);
		dao.close();
		return "Adm Cadastrado";
	}

	public boolean logar(Adm adm) throws Exception {

		AdmDAO dao = new AdmDAO();
		Adm objAdm = dao.getAdm(adm.getCodigo());
		boolean logar = false;

		if (objAdm.getSenha().equals(adm.getSenha()) && objAdm.getCodigo() == adm.getCodigo()) {
			
			dao.getAdm(objAdm.getCodigo());
			return logar = true;
		}
		if (objAdm.getCodigo() < 5) {
			return logar == false;
		}
		if (logar) {
			return adm.isLogado() == true;
		} else {
			return adm.isLogado() == false;
		}

	}

	public String atualizarData(Adm adm, String dataGuardada) throws Exception {
		AdmDAO dao = new AdmDAO();
		dataGuardada = guardarData(adm);
		dao.updateDataInativa(adm.getCodigo(), dataGuardada);
		dao.close();
		return "Data Atualizada";

	}

	public String guardarData(Adm adm) throws Exception {
		if (adm.isLogado()) {
			AdmDAO dao = new AdmDAO();
			Adm objAdm = dao.getAdm(adm.getCodigo());
			DateFormat ultimaData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date data = new Date();
			 objAdm.setDataInativacao(ultimaData.format(data));
			 dao.close();
			return objAdm.getDataInativacao();
		} else {
			AdmDAO dao = new AdmDAO();
			Adm objAdm = dao.getAdm(adm.getCodigo());
			dao.close();
			return objAdm.getDataInativacao();
		}

	}
	
	public String atualizarSenha(int cod, String novaSenha, Usuario usu) throws Exception{
		AdmDAO dao = new AdmDAO();
		Adm objAdm = dao.getAdm(cod);
		novaSenha = objAdm.getSenha();
		if (novaSenha.length() < 7) {
			return "Senha Inválida";
		}	
		if(usu.getSenha().equals(novaSenha)) {
			return "A senha é a mesma da anterior";
		}
		dao.updatePassword(objAdm.getCodigo(), novaSenha);
		dao.close();
		return "Senha Atualizada";
	}
	
	public String apagarUsuario(Adm adm) throws Exception{
		AdmDAO dao = new AdmDAO();
		Adm objAdm = dao.getAdm(adm.getCodigo());
			
		
		dao.deleteAdm(objAdm.getCodigo());
		dao.close();
		return "Usuario Apagado";
	}

}
