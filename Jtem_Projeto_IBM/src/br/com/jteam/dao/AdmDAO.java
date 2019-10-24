package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jteam.beans.Adm;
import br.com.jteam.conexao.Conexao;

public class AdmDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public int updatePassword(int cod, String newPassword) throws Exception {
		stmt = con.prepareStatement("UPDATE T_JTEAM_ADM   SET SN_SENHA=? WHERE" + "CD_USUARIO=?");
		stmt.setString(1, newPassword);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}
	public void close() throws Exception{
		con.close();
	}
	
	public AdmDAO() throws Exception{
		con = Conexao.getConnection();
	}
	public int deleteAdm(int cod) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_JTEAM_ADM  WHERE CD_USUARIO=?");
		stmt.setInt(1, cod);
		return stmt.executeUpdate();
	}
	
	public int addAdm (Adm adm) throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_ADM (CD_USUARIO, NM_USUARIO, SN_USUARIO,DS_EMAIL, DT_NASCIMENTO,DT_INATIVACAO, DS_CERTIFICADO) VALUES(?,?,?,?,?,?,?)");
		stmt.setInt(1, adm.getCodigo());
		stmt.setString(2, adm.getNome());
		stmt.setString(3,  adm.getSenha());
		stmt.setString(4,adm.getEmail());
		stmt.setString(5, adm.getDataNascimento());
		stmt.setString(6, adm.getDataInativacao());
		stmt.setString(7, adm.getCertificado());
		return stmt.executeUpdate();
	}
	
	public int updateDataInativa(int cod, String novaData) throws Exception{
		stmt =  con.prepareStatement("UPDATE T_JTEAM_ADM SET DT_INATIVACAO=? WHERE" + "CD_USUARIO=?");
		stmt.setString(1, novaData);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}
	
	public Adm getAdm(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_ADM WHERE CD_USUARIO=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Adm objeto = new Adm();
			objeto.setCodigo(rs.getInt("CD_USUARIO"));
			objeto.setNome(rs.getString("NM_USUARIO"));
			objeto.setEmail(rs.getString("DS_EMAIL"));
			objeto.setSenha(rs.getString("SN_USUARIO"));
			objeto.setDataNascimento(rs.getString("DT_NASCIMENTO"));
			objeto.setDataInativacao(rs.getString("DT_INATIVACAO"));
			objeto.setCertificado(rs.getString("DS_CERTIFICADO"));
			return objeto;
			}else {
				return new Adm();
			}
	}

}
