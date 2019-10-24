package br.com.jteam.beans;

public class Avaliacao implements Comparable <Avaliacao>{
	private Disciplina disciplina;
	private Questao questao;
	private int codigo;
	private String titulo;
	
	
	@Override
	public int compareTo(Avaliacao qual) {
		return titulo.compareTo(qual.titulo);
	}
	
	public Avaliacao(int codigo, Disciplina disciplina, Questao questao,  String titulo) {
		super();
		this.disciplina = disciplina;
		this.questao = questao;
		this.codigo = codigo;
		this.titulo = titulo;
	}
	
	public Avaliacao() {

	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
}
