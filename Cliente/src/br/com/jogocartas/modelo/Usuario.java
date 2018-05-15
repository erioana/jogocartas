package br.com.jogocartas.modelo;

import java.io.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nome;
	private String senha;
	
	public Usuario(){
		
	}

	public Usuario(String email, String nome, String senha) throws Exception {
		this.setEmail(email);
		this.setNome(nome);
		this.setSenha(senha);
	}
	
	public void setEmail(String email) throws Exception {

		if(validar(email))
			this.email = email;
		else
			throw new Exception("E-mail inválido!");
			
	}

	public void setNome(String nome) throws Exception {
		this.nome = nome;
	}

	public void setSenha(String senha) throws Exception {
		this.senha = senha;
	}

	public String getEmail() {
		return this.email;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSenha() {
		return this.senha;
	}

	/**
	 * Metodo responsavel por fazer a validacao do email
	 * 
	 * @param email: email que será validado
	 * 
	 * @return true: retorna true caso o email informado seja um email valido
	 *         false: retorna false caso o email informado seja um email falso
	 * */
	public boolean validar(String email) {
		boolean isEmailValid = false;
		if(email != null && email.length() > 0) {
			String exprecao = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(exprecao, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailValid = true;
            }
		}
		
		return isEmailValid;
	}

}
