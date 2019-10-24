package br.com.jteam.beans;
public class Progressao {
	private boolean status;
	private Disciplina disciplina;
	private int avaliacao;
	
	
	public Progressao(boolean status, Disciplina dis, int avaliacao) {
		super();
		this.status = status;
		this.disciplina = dis;
		this.avaliacao = avaliacao;
	}
	
	public Progressao() {

	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
}
