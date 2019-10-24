package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jteam.beans.Disciplina;
import br.com.jteam.beans.Progressao;
import br.com.jteam.conexao.Conexao;

public class ProgressaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ProgressaoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	public int addProgressao(Progressao pro ) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_PROGRESSAO (CD_DISCIPLINA, ST_RESPOSTA,NR_AVALIACAO) VALUES (?,?,?)");
		stmt.setInt(1, pro.getDisciplina().getCodigo());
		stmt.setBoolean(2, pro.isStatus());
		stmt.setInt(3, pro.getAvaliacao());
		return stmt.executeUpdate();
	}
	
	public Progressao getProgressao(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_PROGRESSAO WHERE CD_DISCIPLINA=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Progressao objeto = new Progressao();
			objeto.setStatus(rs.getBoolean("ST_RESPOSTA"));
			objeto.setAvaliacao(rs.getInt("NR_AVALIACAO"));
			DisciplinaDAO disDao = new DisciplinaDAO();
			Disciplina dis = disDao.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			disDao.close();
			objeto.setDisciplina(dis);
			
			return objeto;
			}else {
				return new Progressao();
				
			}
	}
	
	public void close()throws Exception{
		con.close();
	}
	
	public int deleteAvaliacao(int codigo) throws Exception{
		stmt = con.prepareStatement
	("DELETE FROM T_JTEAM_PROGRESSAO WHERE CD_DISCIPLINA=?");
		stmt.setInt(1, codigo);
		return stmt.executeUpdate();
	}
	
	public int updateAvaliacao(Progressao pro) 
			throws Exception{
		stmt = con.prepareStatement
				("UPDATE T_JTEAM_PROGRESSAO SET NR_AVALIACAO=?, ST_RESPOSTA=? WHERE CD_DISCIPLINA=?");
		stmt.setBoolean(1, pro.isStatus());
		stmt.setInt(2, pro.getAvaliacao());
		
		return stmt.executeUpdate();
	}
}
