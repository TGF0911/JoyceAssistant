package br.com.jteam.beans;

public class Questao {

	private int codigo;
	private String descricao;
	private String altA;
	private String altB;
	private String altC;
	private String altD;
	private int altCorreta;
	private int pesoQuestao;
	
	public Questao(int codigo, String descricao, String altA, String altB, String altC, String altD, int altCorreta, int pesoQuestao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.altCorreta = altCorreta;
		this.pesoQuestao =pesoQuestao;
				
	}
	
	public Questao() {
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getAltCorreta() {
		return altCorreta;
	}
	public void setAltCorreta(int altCorreta) {
		this.altCorreta = altCorreta;
	}
	public int getPesoQuestao() {
		return pesoQuestao;
	}
	public void setPesoQuestao(int pesoQuestao) {
		this.pesoQuestao = pesoQuestao;
	}
	public String getAltA() {
		return altA;
	}
	public void setAltA(String altA) {
		this.altA = altA;
	}
	public String getAltB() {
		return altB;
	}
	public void setAltB(String altB) {
		this.altB = altB;
	}
	public String getAltC() {
		return altC;
	}
	public void setAltC(String altC) {
		this.altC = altC;
	}
	public String getAltD() {
		return altD;
	}
	public void setAltD(String altD) {
		this.altD = altD;
	}
	
	
}
