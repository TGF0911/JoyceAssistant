package br.com.jteam.beans;

public class Aluno extends Usuario{


	private String curso;
	private String endereco;
	private boolean notificacao;
	private boolean status;
	private String escolaridade;
	private String telefone;
	
	
	public Aluno(int codigo, String nome, String senha, String email, String dataNascimento, String dataInativacao,
			boolean logado, String curso, String endereco, boolean notificacao, boolean status, String escolaridade, String telefone) {
		super(codigo, nome, senha, email, dataNascimento, dataInativacao, logado);
		this.curso = curso;
		this.endereco = endereco;
		this.notificacao = notificacao;
		this.status = status;
		this.escolaridade = escolaridade;
		this.telefone = telefone;
	}
	
	public Aluno() {
	}
		
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isNotificacao() {
		return notificacao;
	}

	public void setNotificacao(boolean notificacao) {
		this.notificacao = notificacao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
