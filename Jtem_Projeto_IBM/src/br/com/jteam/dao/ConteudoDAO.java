package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.jteam.beans.Conteudo;
import br.com.jteam.conexao.Conexao;

public class ConteudoDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ConteudoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	public int addConteudo(Conteudo conteudo) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_CONTEUDO(CD_CONTEUDO,NM_CONTEUDO, DS_DOCUMENTO)");
		stmt.setInt(1, conteudo.getCodigo());
		stmt.setString(2, conteudo.getNome());
		stmt.setString(3, conteudo.getDocumento());
		return stmt.executeUpdate();
	}
	
	public int updateDocumento(int cod, String novoDocumento) throws Exception {
		stmt = con.prepareStatement("UPDATE T_JTEAM_CONTEUDO SET DS_DOCUMENTO=? WHERE" + "CD_CONTEUDO=?");
		stmt.setString(1, novoDocumento);
		stmt.setInt(2,cod);
		return stmt.executeUpdate();
	}
	
	public int deleteConteudo(int cod) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_JTEAM_CONTEUDO WHERE CD_CONTEUDO=?");
		stmt.setInt(1, cod);
		return stmt.executeUpdate();
	}
	
	public Conteudo getConteudo(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_CONTEUDO WHERE CD_CONTEUDO=?");
		stmt.setInt(1,cod);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Conteudo objetoCont = new Conteudo();
			objetoCont.setCodigo(rs.getInt("CD_CONTEUDO"));
			objetoCont.setNome(rs.getString("NM_CONTEUDO"));
			objetoCont.setDocumento(rs.getString("DS_DOCUMENTO"));
			
			return objetoCont;
			}else {
				return new Conteudo();
				
			}
	}
	
	public List<Conteudo> pesquisarCont(int cod) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_CONTEUDO INNER JOIN T_JTEAM_DISCIPLINA ON T_JTEAM_CONTEUDO.CD_CONTEUDO = T_JTEAM_DISCIPLINA.CD_CONTEUDO  = ");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		List<Conteudo> conteudo = new ArrayList<Conteudo>();
		while(rs.next()) {
			conteudo.add(new Conteudo(rs.getInt("CD_CONTEUDO"), rs.getString("NM_CONTEUDO"), rs.getString("DS_DOCUMENTO"))); 
		}
		return conteudo;
	}
	
	public void close() throws Exception{
		con.close();
	}
	
}
