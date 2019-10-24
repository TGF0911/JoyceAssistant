package br.com.jteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.jteam.beans.Avaliacao;
import br.com.jteam.beans.Conteudo;
import br.com.jteam.beans.Disciplina;
import br.com.jteam.beans.Questao;
import br.com.jteam.conexao.Conexao;

public class AvaliacaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public AvaliacaoDAO() throws Exception {
		con = Conexao.getConnection();
	}

	public int addAvaliacao(Avaliacao av) throws Exception {
		stmt = con.prepareStatement(
				"INSERT INTO T_JTEAM_AVALIACAO (CD_DISCIPLINA, CD_AVALIACAO, CD_QUESTAO, NM_TITULO) VALUES (?,?,?,?)");
		stmt.setInt(1, av.getDisciplina().getCodigo());
		stmt.setInt(2, av.getCodigo());
		stmt.setInt(3, av.getQuestao().getCodigo());
		stmt.setString(4, av.getTitulo());
		return stmt.executeUpdate();
	}

	public Avaliacao getAvaliacao(int cod) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_JTEAM_DISCIPLINA WHERE CD_AVALIACAO=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			Avaliacao objeto = new Avaliacao();
			objeto.setCodigo(rs.getInt("CD_AVALIACAO"));
			objeto.setTitulo(rs.getString("NM_TITULO"));
			DisciplinaDAO disDao = new DisciplinaDAO();
			Disciplina dis = disDao.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			QuestaoDAO questDao = new QuestaoDAO();
			Questao quest = questDao.getQuest(rs.getInt("CD_QUESTAO"));
			disDao.close();
			questDao.close();
			objeto.setDisciplina(dis);
			objeto.setQuestao(quest);

			return objeto;
		} else {
			return new Avaliacao();

		}
	}

	public void close() throws Exception {
		con.close();
	}

	public int deleteAvaliacao(int codigo) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_JTEAM_AVALIACAO WHERE CD_AVALIACAO=?");
		stmt.setInt(1, codigo);
		return stmt.executeUpdate();
	}

	public int updateAvaliacao(int cod, String novoTitulo) throws Exception {
		stmt = con.prepareStatement("UPDATE T_JTEAM_AVALIACAO SET NM_TITULO=? WHERE CD_AVALIACAO=?");
		stmt.setString(1, novoTitulo);
		stmt.setInt(2, cod);
		return stmt.executeUpdate();
	}

	// ENTREGAR ESSE COMO OUTPUT
	public List<Avaliacao> pequisarAvaliacao(int cod) throws Exception {
		stmt = con.prepareStatement(
				"SELECT * FROM T_JTEAM_AVALIACAO INNER JOIN T_JTEAM_DISCIPLINA, T_JTEAM_QUESTAO ON T_JTEAM_AVALIACAO.CD_DISCIPLINA = T_JTEAM_DISCIPLINA.CD_DISCIPLINA, T_JTEAM_AVALIACAO.CD_QUESTAO = T_JTEAM_QUESTAO.CD_QUESTAO WHERE CD_AVALIACAO =?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
		while (rs.next()) {
			avaliacao.add(new Avaliacao(rs.getInt("CD_AVALIACAO"),
					new Disciplina(rs.getInt("CD_DISCIPLINA"), rs.getString("NM_DISCIPLINA"), rs.getString("DT_INICIO"),
							rs.getString("DT_TERMINO"), rs.getBoolean("ST_DISCIPLINA"),
							new Conteudo(rs.getInt("CD_CONTEUDO"), rs.getString("NM_CONTEUDO"),rs.getString("DS_DOCUMENTO"))),
					new Questao(rs.getInt("CD_QUESTAO"), rs.getString("DS_DESCRICAO"), rs.getString("DS_ALTERNATIVA_A"),
							rs.getString("DS_ALTERNATIVA_B"), rs.getString("DS_ALTERNATIVA_C"),
							rs.getString("DS_ALTERNATIVA_D"), rs.getInt("DS_ALTERNATIVA_CORRETA"),
							rs.getInt("NR_PESO")),
					rs.getString("NM_TITULO")));
		}
		return avaliacao;
	}

}
