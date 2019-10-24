package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.jteam.beans.Conteudo;
import br.com.jteam.beans.Disciplina;
import br.com.jteam.conexao.Conexao;

public class DisciplinaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public DisciplinaDAO() throws Exception {
		con = Conexao.getConnection();
	}

	public int addDisciplina(Disciplina dis) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_JTEAM_DISCIPLINA(CD_DISCIPLINA, NM_NOME, DT_INICIO, DT_TERMINO)");
		stmt.setInt(1, dis.getCodigo());
		stmt.setString(2, dis.getNome());
		stmt.setString(3, dis.getDataInicio());
		stmt.setString(4, dis.getDataTermino());
		stmt.setInt(5, dis.getConteudo().getCodigo());
		return stmt.executeUpdate();
	}

	public int deleteDisciplina(int cod) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_JTEAM_DISCIPLINA WHERE CD_DISCIPLINA=?");
		stmt.setInt(1, cod);
		return stmt.executeUpdate();
	}

	public Disciplina getDisciplina(int cod) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_DISCIPLINA WHERE CD_DISCIPLINA=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			Disciplina objetoDis = new Disciplina();
			objetoDis.setCodigo(rs.getInt("CD_DISCIPLINA"));
			objetoDis.setNome(rs.getString("NM_DISCIPLINA"));
			objetoDis.setDataInicio(rs.getString("DT_INICIO"));
			objetoDis.setDataTermino(rs.getString("DT_TERMINO"));

			return objetoDis;
		} else {
			return new Disciplina();

		}
	}

	public void close() throws Exception {
		con.close();
	}

	public List<Disciplina> pesquisarDisciplina(int cod) throws Exception {
		stmt = con.prepareStatement(
				"SELECT * FROM T_JTEAM_DISCIPLINA  INNER JOIN T_JTEAM_CONTEUDO ON T_JTEAM_DISCIPLINA.CD_CONTEUDO = T_JTEAM_CONTEUDO.CD_CONTEUDO WHERE CD_DISCIPLINA=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		List<Disciplina> disciplina = new ArrayList<Disciplina>();
		while (rs.next()) {
			disciplina.add(
					new Disciplina(
							rs.getInt("CD_DISCIPLINA"), 							
							rs.getString("NM_DISCIPLINA"),
							rs.getString("DT_INICIO"), 							
							rs.getString("DT_TERMINO"), 							
							rs.getBoolean("ST_DISCIPLINA"),
					new Conteudo(
							rs.getInt("CD_CONTEUDO"), 							
							rs.getString("NM_CONTEUDO"), 							
							rs.getString("DS_DOCUMENTO")))
					);
		}

		return disciplina;
	}

}
