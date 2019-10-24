package br.com.jteam.beans;

public class Conteudo implements Comparable <Conteudo>{

	private int codigo;
	private String nome;
	private String documento;
	
	
	@Override
	public int compareTo(Conteudo cod) {
		if(codigo<cod.codigo) {
			return -1;
		}else if (codigo>cod.codigo) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public Conteudo(int codigo, String nome, String documento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.documento = documento;
	}
	
	public Conteudo() {

	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
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

	
}
