package br.com.jteam.execao;

import java.sql.SQLException;

public class Excecao extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6043001160081559724L;
	
	public static String tratarExcecao(Exception e) {
		if(e instanceof NumberFormatException) {
			return "N�mero Inv�lido";
		}else if (e instanceof NullPointerException) {
			return "Objeto Nulo";
		}else if (e instanceof SQLException) {
			return "Falha na conex�o com BD";
		}else {
			return "Falha Desconhecida";
		}
	}//main
	
}
