package br.com.jogocartas.comunicacao;

import java.io.Serializable;

import br.com.jogocartas.modelo.Usuario;

/**
 * Classe para guardar os dados da solicitacao feita pelo Client
 * para ser enviada para o Servidor
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */
public class Solicitacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	private String protocolo, complemento1, complemento2, complemento3;

	// CAD (CADASTRAR) -> COMPLEMENTO 1 EMAIL COMP 2 NOME COMP 3 SENHA
	// LOG (LOGIN) -> COMP 1 EMAIL COMP 2 SENHA SEM COMP 3
	// SUC SUCESSO-> SEM COMP

	// ERR ERRO -> SEM COMP
	public Solicitacao(String cmd, String comp1) {
		this.protocolo = cmd;
		this.complemento1 = comp1;
	}
	
	/**
	 * Método Construtor, que receberá como parâmetro as seguintes variaveis
	 * @param cmd varivável que determina que tipo de solicitação é ( CAD para cadastrar ou LOG para logar )
	 * @param comp1 variável que guarda o e-mail do usuário
	 * @param comp2 variável que guarda a senha do usuário
	 */
	public Solicitacao(String cmd, String comp1, String comp2) {
		this.protocolo = cmd;
		this.complemento1 = comp1;
		this.complemento2 = comp2;
	}
	/**
	 * Método Construtor, que receberá como parâmetro as seguintes variaveis
	 * @param cmd varivável que determina que tipo de solicitação é ( CAD para cadastrar ou LOG para logar )
	 * @param comp1 variável que guarda o e-mail do usuário
	 * @param comp2 variável que guarda o nome do usuário
	 * @param comp3 variável que guarda a senha do usuário
	 */
	public Solicitacao(String cmd, String comp1, String comp2, String comp3) {
		this.protocolo = cmd;
		this.complemento1 = comp1;
		this.complemento2 = comp2;
		this.complemento3 = comp3;
	}
	
	public Solicitacao(Usuario usuario, String protocolo){
		this.usuario = usuario;
		this.protocolo = protocolo;
		
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getComplemento1() {
		return complemento1;
	}

	public void setComplemento1(String complemento1) {
		this.complemento1 = complemento1;
	}

	public String getComplemento2() {
		return complemento2;
	}

	public void setComplemento2(String complemento2) {
		this.complemento2 = complemento2;
	}

	public String getComplemento3() {
		return complemento3;
	}

	public void setComplemento3(String complemento3) {
		this.complemento3 = complemento3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((protocolo == null) ? 0 : protocolo.hashCode());
		result = prime * result + ((complemento1 == null) ? 0 : complemento1.hashCode());
		result = prime * result + ((complemento2 == null) ? 0 : complemento2.hashCode());
		result = prime * result + ((complemento3 == null) ? 0 : complemento3.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		if (protocolo == null) {
			if (other.protocolo != null)
				return false;
		} else if (!protocolo.equals(other.protocolo))
			return false;
		if (complemento1 == null) {
			if (other.complemento1 != null)
				return false;
		} else if (!complemento1.equals(other.complemento1))
			return false;
		if (complemento2 == null) {
			if (other.complemento2 != null)
				return false;
		} else if (!complemento2.equals(other.complemento2))
			return false;
		if (complemento3 == null) {
			if (other.complemento3 != null)
				return false;
		} else if (!complemento3.equals(other.complemento3))
			return false;
		return true;
	}	
}
