package br.com.jteam.beans;

public class TesteExecutado {
	
	private MontarTeste montarTeste;
	private boolean Statusresposta;
	
	public TesteExecutado(MontarTeste mTeste, boolean resposta) {
		super();
		this.montarTeste = mTeste;
		this.Statusresposta = resposta;
	}
	
	public TesteExecutado() {
	}
	
	public MontarTeste getMontarTeste() {
		return montarTeste;
	}
	public void setMontarTeste(MontarTeste montarTeste) {
		this.montarTeste = montarTeste;
	}
	public boolean isStatusresposta() {
		return Statusresposta;
	}
	public void setStatusresposta(boolean statusresposta) {
		Statusresposta = statusresposta;
	}
	
	
	
}
