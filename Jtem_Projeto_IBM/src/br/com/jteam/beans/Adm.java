package br.com.jteam.beans;

public class Adm  extends Usuario implements Comparable <Adm>{
	private int codigo;
	private String certificado;
	

	@Override
	public int compareTo(Adm cod) {
		if(codigo<cod.codigo) {
			return -1;
		}else if(codigo>cod.codigo) {
			return 1;
		}else {
			return 0;
		}
	}
	public Adm(int codigo, String nome, String senha, String email, String dataNascimento, String dataInativacao,
			boolean logado, String certificado) {
		super(codigo, nome, senha, email, dataNascimento, dataInativacao, logado);
		this.certificado = certificado;
		this.codigo = codigo;
	}
	
	
	public Adm() {
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	
}
