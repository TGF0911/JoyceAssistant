package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jteam.beans.Aluno;
import br.com.jteam.conexao.Conexao;



public class AlunoDAO  {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public int updatePassword(int cod, String newPassword) throws Exception {
		stmt = con.prepareStatement("UPDATE T_JTEAM_ALUNO   SET SN_SENHA=? WHERE" + "CD_USUARIO=?");
		stmt.setString(1, newPassword);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}
	public void close() throws Exception{
		con.close();
	}
	
	public AlunoDAO() throws Exception{
		con = Conexao.getConnection();
	}
	public int deleteAluno(int cod) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_JTEAM_ALUNO  WHERE CD_USUARIO=?");
		stmt.setInt(1, cod);
		return stmt.executeUpdate();
	}
	
	public int addAluno (Aluno al) throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_ALUNO (CD_USUARIO, NM_USUARIO, SN_USUARIO,DS_EMAIL, DT_NASCIMENTO,DT_INATIVACAO, DS_CURSO, DS_ENDERECO, ST_NOTIFICACAO, DS_ESCOLARIDADE, DS_TELEFONE) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setInt(1, al.getCodigo());
		System.out.println(al.getCodigo());
		stmt.setString(2, al.getNome());
		System.out.println(al.getNome());
		stmt.setString(3,  al.getSenha());
		System.out.println(al.getSenha());
		stmt.setString(4,al.getEmail());
		System.out.println(al.getEmail());
		stmt.setString(5, al.getDataNascimento());
		System.out.println(al.getDataNascimento());
		stmt.setString(6, al.getDataInativacao());System.out.println("Dat"+al.getDataInativacao());
		stmt.setString(7, al.getCurso());System.out.println(al.getCurso());
		stmt.setString(8, al.getEndereco());System.out.println(al.getEndereco());
		stmt.setBoolean(9, al.isNotificacao());System.out.println(al.isNotificacao());
		stmt.setString(11, al.getTelefone());System.out.println(al.getTelefone());
		stmt.setString(12, al.getEscolaridade());System.out.println(al.getEscolaridade());
		System.out.println(stmt);
		return stmt.executeUpdate();
	}
	
	public int updateDataInativa(int cod, String novaData) throws Exception{
		stmt =  con.prepareStatement("UPDATE T_JTEAM_ALUNO SET DT_INATIVACAO=? WHERE" + "CD_USUARIO=?");
		stmt.setString(1, novaData);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}
	
	public Aluno getAluno(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_ALUNO WHERE CD_USUARIO=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Aluno objeto = new Aluno();
			objeto.setCodigo(rs.getInt("CD_USUARIO"));
			objeto.setNome(rs.getString("NM_USUARIO"));
			objeto.setEmail(rs.getString("DS_EMAIL"));
			objeto.setSenha(rs.getString("SN_USUARIO"));
			objeto.setDataNascimento(rs.getString("DT_NASCIMENTO"));
			objeto.setDataInativacao(rs.getString("DT_INATIVACAO"));
			objeto.setCurso(rs.getString("DS_CURSO"));
			objeto.setEndereco(rs.getString("DS_ENDERECO"));
			objeto.setNotificacao(rs.getBoolean("ST_NOTIFICACAO"));
			objeto.setStatus(rs.getBoolean("ST_STATUS"));
			objeto.setEscolaridade(rs.getString("DS_ESCOLARIDADE"));
			objeto.setTelefone(rs.getString("DS_TELEFONE"));
			return objeto;
			}else {
				return new Aluno();
			}
	}
	
	

	
	
}
