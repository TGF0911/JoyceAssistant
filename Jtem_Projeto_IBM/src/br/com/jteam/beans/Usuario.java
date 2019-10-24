package br.com.jteam.beans;



public class Usuario {
	private String nome;
	private int codigo;
	private String senha;
	private String email;
	private String dataNascimento;
	private String dataInativacao;
	private boolean logado = false;
	
	public Usuario(int codigo, String nome, String senha, String email, String dataNascimento, String dataInativacao, boolean logado) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataInativacao = dataInativacao;
		this.logado = logado;
		
	}
	
	

	public Usuario() {
	}



	public String getDataInativacao() {
		return dataInativacao;
	}


	public void setDataInativacao(String dataInativacao) {
		this.dataInativacao = dataInativacao;
	}


	public boolean isLogado() {
		return logado;
	}


	public void setLogado(boolean logado) {
		this.logado = logado;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
}
