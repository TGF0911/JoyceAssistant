package br.com.jteam.beans;

public class Disciplina implements Comparable <Disciplina> {
	
	private int codigo;
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private boolean status = false; 
	private Conteudo conteudo;
	
	//PROGRESSO SERIA FUNCIONALIDADE
	//TESTE PODE SER UMA FUNCIONALIDADE
	//FAZER MONTAR TESTE, TESTE EXECUTADO E PROGRESSAO
	
	@Override
	public int compareTo(Disciplina cod) {
		if(codigo<cod.codigo) {
			return -1;
		}else if (codigo>cod.codigo) {
			return 1;
		}else {
			return 0;
		}
	}



	public Disciplina(int codigo, String nome, String dataInicio, String dataTermino, boolean status, Conteudo cont){
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.conteudo = cont;
	}
	
	public Disciplina() {

	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Conteudo getConteudo() {
		return conteudo;
	}
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

}
