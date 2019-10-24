package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.jteam.beans.Questao;
import br.com.jteam.conexao.Conexao;

public class QuestaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public QuestaoDAO() throws Exception{
		con = Conexao.getConnection();
	}
	
	
	public int addQuest(Questao quest) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_QUESTAO (CD_QUESTAO, DS_QUESTAO, DS_ALTERNATIVA_A, DS_ALTERNATIVA_B,DS_ALTERNATIVA_C,DS_ALTERNATIVA_D, DS_ALTERNATICA_CORRETA,NR_PESO)");
		stmt.setInt(1, quest.getCodigo());
		stmt.setString(2, quest.getDescricao());
		stmt.setString(3, quest.getAltA());
		stmt.setString(4, quest.getAltB());
		stmt.setString(5, quest.getAltC());
		stmt.setString(6, quest.getAltD());
		stmt.setInt(7, quest.getAltCorreta() );
		stmt.setInt(8,quest.getPesoQuestao());
		return stmt.executeUpdate();
	}
	
	public int deleteQuest(int cod) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_JTEAM_QUESTAO WHERE CD_QUESTAO=? ");
		stmt.setInt(1,cod);
		return stmt.executeUpdate();
	}
	
	
	public int updatePeso(int cod, int peso) throws Exception{
		stmt = con.prepareStatement("UPDTE T_JTEAM_QUESTAO SET NR_PESO=? WHERE CD_QUESTAO=?");
		stmt.setInt(1, peso);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}
	
	public Questao getQuest(int cod) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_QUESTAO WHERE CD_QUESTAO=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Questao objeto = new Questao();
			objeto.setCodigo(rs.getInt("CD_USUARIO"));
			objeto.setDescricao(rs.getString("DS_QUESTAO"));
			objeto.setAltCorreta(rs.getInt("DS_ALTERNATIVA_CORRETA"));
			objeto.setAltA(rs.getString("DS_ALTERNATIVA_A"));
			objeto.setAltB(rs.getString("DS_ALTERNATIVA_B"));
			objeto.setAltC(rs.getString("DS_ALTERNATIVA_C"));
			objeto.setAltD(rs.getString("DS_ALTERNATIVA_D"));
			return objeto;
			}else {
				return new Questao();
			}
	}
	
	public void close() throws Exception{
		con.close();
	}
	
	public List<Questao> pesquisarQuestao(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_QUESTAO WHERE CD_QUESTAO = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		List<Questao> questao  = new ArrayList<Questao>();
		while(rs.next()) {
			questao.add(
					new Questao(
							rs.getInt("CD_QUESTAO"),
							rs.getString("DS_DESCRICAO"),
							rs.getString("DS_ALTERNATIVA_A"),
							rs.getString("DS_ALTERNATIVA_B"),
							rs.getString("DS_ALTERNATIVA_C"),
							rs.getString("DS_ALTERNATIVA_D"), 
							rs.getInt("DS_ALTERNATIVA_CORRETA"),
							rs.getInt("NR_PESO")));
		}
		
		return questao;
	}
	
}
