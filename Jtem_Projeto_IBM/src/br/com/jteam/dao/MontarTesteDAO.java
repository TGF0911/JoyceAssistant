package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jteam.beans.Avaliacao;
import br.com.jteam.beans.MontarTeste;
import br.com.jteam.beans.Questao;
import br.com.jteam.conexao.Conexao;

public class MontarTesteDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public MontarTesteDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	public int addMontarTeste(MontarTeste montar) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_MONTAR_TESTE (CD_AVALIACAO, CD_MONTAR_TESTE, CD_QUESTAO) VALUES (?,?,?)");
		stmt.setInt(1, montar.getAvaliacao().getCodigo());
		stmt.setInt(2, montar.getCodigo());
		stmt.setInt(3, montar.getQuestao().getCodigo());
		return stmt.executeUpdate();
	}
	
	public MontarTeste getMontarTeste(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_MONTAR_TESTE WHERE CD_MONTAR_TESTE=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			MontarTeste objeto = new MontarTeste();
			objeto.setCodigo(rs.getInt("CD_MONTAR-TESTE"));
			QuestaoDAO questDao = new QuestaoDAO();
			Questao quest = questDao.getQuest(rs.getInt("CD_QUESTAO"));
			AvaliacaoDAO avaDao = new AvaliacaoDAO();
			Avaliacao ava = avaDao.getAvaliacao(rs.getInt("CD_AVALIACAO"));
			questDao.close();
			avaDao.close();
			objeto.setQuestao(quest);
			objeto.setAvaliacao(ava);
			return objeto;
			}else {
				return new MontarTeste();
				
			}
	}
	public void close()throws Exception{
		con.close();
	}
	
	public int deleteMontarTetse(int codigo) throws Exception{
		stmt = con.prepareStatement
	("DELETE FROM T_JTEAM_MONTAR_TESTE WHERE CD_MONTAR_TESTE=?");
		stmt.setInt(1, codigo);
		return stmt.executeUpdate();
	}
	
	public int updateMontar(MontarTeste objeto) 
			throws Exception{
		stmt = con.prepareStatement
				("UPDATE T_JTEAM_MONTAR_TESTE SET CD_AVALIACAO=? WHERE CD_MONTAR_TESTE=?");
		stmt.setInt(1, objeto.getAvaliacao().getCodigo());
		return stmt.executeUpdate();
	}
	
}
