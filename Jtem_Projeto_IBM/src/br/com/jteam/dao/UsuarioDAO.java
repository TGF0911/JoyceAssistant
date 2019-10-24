package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jteam.beans.Usuario;
import br.com.jteam.conexao.Conexao;

public class UsuarioDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	
	public int updatePassword(int cod, String newPassword) throws Exception {
		stmt = con.prepareStatement("UPDATE JTEAM_USUAIRO   SET SN_SENHA=? WHERE" + "CD_USUARIO=?");
		stmt.setString(1, newPassword);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}
	public void close() throws Exception{
		con.close();
	}
	
	public UsuarioDAO() throws Exception{
		con = Conexao.getConnection();
	}
	public int deleteUser(int cod) throws Exception{
		stmt = con.prepareStatement("DELETE FROM JTEAM_USUARIO  WHERE CD_USUARIO=?");
		stmt.setInt(1, cod);
		return stmt.executeUpdate();
	}
	
	public int addUser (Usuario usu) throws Exception{
		stmt = con.prepareStatement("INSERT INTO JTEAM_USUARIO (CD_USUARIO, NM_USUARIO, SN_USUARIO,DS_EMAIL, DT_NASCIMENTO,DT_INATIVACAO)");
		stmt.setInt(1, usu.getCodigo());
		stmt.setString(2, usu.getNome());
		stmt.setString(3,  usu.getSenha());
		stmt.setString(4,usu.getEmail());
		stmt.setString(5, usu.getDataNascimento());
		stmt.setString(6, usu.getDataInativacao());
		return stmt.executeUpdate();
	}
	
	public int updateDataInativa(int cod, String novaData) throws Exception{
		stmt =  con.prepareStatement("UPDATE JTEAM_USUARIO SET DT_INATIVACAO=? WHERE" + "CD_USUARIO=?");
		stmt.setString(1, novaData);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}
	
	public Usuario getUser(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM JTEAM_USUARIO WHERE CD_USUARIO=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Usuario objeto = new Usuario();
			objeto.setCodigo(rs.getInt("CD_USUARIO"));
			objeto.setNome(rs.getString("NM_USUARIO"));
			objeto.setEmail(rs.getString("DS_EMAIL"));
			objeto.setSenha(rs.getString("SN_USUARIO"));
			objeto.setDataNascimento(rs.getString("DT_NASCIMENTO"));
			objeto.setDataInativacao(rs.getString("DT_INATIVACAO"));
			return objeto;
			}else {
				return new Usuario();
			}
	}
	
	
}
