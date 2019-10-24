package br.com.jteam.beans;

public class MontarTeste implements Comparable <MontarTeste>{
	
	private int codigo;
	private Questao questao;
	private Avaliacao avaliacao;
	
	@Override
	public int compareTo(MontarTeste cod) {
		if(codigo<cod.codigo) {
			return -1;
		}else if(codigo>cod.codigo) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public MontarTeste(int codigo, Questao quest,Avaliacao ava ) {
		super();
		this.codigo = codigo;
		this.questao = quest;
		this.avaliacao = ava;
	}
	
	public MontarTeste() {

	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	
	
}
