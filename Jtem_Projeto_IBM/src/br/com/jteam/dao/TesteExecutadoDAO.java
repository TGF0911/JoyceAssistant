package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jteam.beans.TesteExecutado;
import br.com.jteam.conexao.Conexao;

public class TesteExecutadoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public TesteExecutadoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	public int addTesteExecutado(TesteExecutado teste) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_TESTE_EXECUTADO (CD_MONTAR_TESTE, ST_RESPOSTA) VALUES (?,?)");
		stmt.setInt(1, teste.getMontarTeste().getCodigo());
		stmt.setBoolean(2, teste.isStatusresposta());
		return stmt.executeUpdate();
	}
	
	public TesteExecutado getTesteExecutado(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_TESTE_EXECUTADO WHERE CD_MONTAR_TESTE=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			TesteExecutado objeto = new TesteExecutado();
			objeto.getMontarTeste().setCodigo(rs.getInt("CD_MONTAR_TESTE"));
			return objeto;
			}else {
				return new TesteExecutado();
				
			}
	}
	public void close()throws Exception{
		con.close();
	}
	
	public int deleteTesteExecutado(int codigo) throws Exception{
		stmt = con.prepareStatement
	("DELETE FROM T_JTEAM_TESTE_EXECUTADO WHERE CD_MONTAR_TESTE=?");
		stmt.setInt(1, codigo);
		return stmt.executeUpdate();
	}
	
	public int updateAvaliacao(TesteExecutado objeto) 
			throws Exception{
		stmt = con.prepareStatement
				("UPDATE T_JTEAM_TESTE_EXECUTADO SET ST_RESPOSTA=? WHERE CD_MONTAR_TESTE=?");
		stmt.setBoolean(1, objeto.isStatusresposta());
		return stmt.executeUpdate();
	}
}
