package br.com.jogocartas.server.main;
import java.io.*;

import java.net.*;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.jogocartas.server.bd.BD;
import br.com.jogocartas.server.dbos.Usuario;

/**
 * Classe representa o Servidor que executara todas as solicitacoes do Cliente
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 2.0.0
 * 
 * */
public class Servidor extends Thread {
	
	private ObjectInputStream entrada;
	private ObjectOutputStream saida;
	final Socket socket;
	
	public Servidor(Socket socket, ObjectInputStream entrada,ObjectOutputStream saida) {
		this.socket = socket;
		this.entrada = entrada;
		this.saida = saida;
	}
	
	/**
	 *  Método da thread, que recebe/envia respostas para o clientSide, 
	 *  por exemplo, recebe uma solicitacao de cadastro
	 *  com os dados do usuário, faz o cadastro e se tudo ocorrer corretamente, 
	 *  retorna ao usuário que foi cadastrado com sucesso.
	 *  O mesmo para o login.
	 */
	public void run() {
		JSONObject jsonRecebido;

		while (true) {
			
			try {
				 String receivedData = String.valueOf(entrada.readObject());
				 jsonRecebido = new JSONObject(receivedData);
				 
				 /**
				  * Implementar aqui todos os metodos que o sevidor deve chamar baseado em cada protocolo de comunicacao
				  * enviado pelo cliente
				  * 
				  * e.g: caso o protocolo de comunicacao for LOG, então o servidor chamara o metodo que executa o login no sistema
				  *      caso o protocolo de comunicacao for CAD, entao o servidor chamara o metodo que executa o cadastro de usuario no sistema
				  *  
				  * */
				 switch(jsonRecebido.getString("protocolo").toString()){
				 	case "LOG":
				 		efetuarLogin(jsonRecebido);
				 		break;
				 	case "CAD":
				 		 cadastrarUsuario(jsonRecebido);
				 		break;	
				 }
				} catch (IOException e) {
					e.printStackTrace();
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	/**
	 * Esse metodo eh responsavel por gerenciar o cadastramento de um usuario no banco de dados
	 * 
	 * Caso o cadastro do usuario for efetuado com sucesso, esse metodo emitira a mensagem SUC-CAD
	 * para o servidor de saida
	 * 
	 * Caso o cadastro do usuario não for efetuado com sucesso, esse metodo emitira uma mensagem ERR-CAD
	 * para o servidor de saida
	 * 
	 * @param jsonRecebido: objeto json contendo as informações do usuario para cadastramento no banco
	 * 
	 * @throws JSONException 
	 * 
	 * */
	private void cadastrarUsuario(JSONObject jsonRecebido) throws JSONException{
		
		System.out.println("Cadastrar usuario: "+ jsonRecebido.getString("nome").toString());
		
		try {
			if (!BD.USUARIOS.isCadastrado(jsonRecebido.getString("email").toString())) {
				BD.USUARIOS.incluir(jsonRecebido);
				JSONObject jsonResposta = new JSONObject();
				jsonResposta.put("protocolo", "CAD-SUCC");
				this.saida.writeObject(jsonResposta.toString());
			}else {
				JSONObject jsonResposta = new JSONObject();
				jsonResposta.put("protocolo", "CAD-ERR");
				this.saida.writeObject(jsonResposta.toString());
			}
		} catch (Exception erro) {
			System.err.println(erro);
		}
	}
	
	
	/**
	 * Esse metodo eh responsavel por gerenciar o login do usuario no sistema
	 * 
	 * Caso o login for efetuado com sucesso, esse metodo emitira a mensagem SUC-LOG
	 * para o servidor de saida
	 * 
	 * Caso o login não for efetuado com sucesso, esse metodo emitira uma mensagem ERR-LOG
	 * para o servidor de saida
	 * 
	 * @param jsonRecebido: objeto json contendo as informações de login do usuario para validação pelo servidor
	 * 
	 * @throws JSONException 
	 * 
	 * */
	private void efetuarLogin(JSONObject jsonRecebido) throws JSONException{
		
		System.out.println("Usuário " + jsonRecebido.getString("email").toString() + " efetuando login no sistema");
		
		try {
				if (BD.USUARIOS.isCadastrado(jsonRecebido.getString("email").toString())) {
					
					//pega dados do usuario que esta logando
					Usuario user = BD.USUARIOS.getUsuario(jsonRecebido.getString("email").toString());
					
					//verifica se a senha do usuario cadastrada no banco confere com a digitada
					if (jsonRecebido.getString("senha").toString().equals(user.getSenha())) {
						JSONObject jsonResposta = new JSONObject();
						jsonResposta.put("protocolo", "LOG-SUCC");
						this.saida.writeObject(jsonResposta.toString());
					} else {
						JSONObject jsonResposta = new JSONObject();
						jsonResposta.put("protocolo", "LOG-ERR");
						this.saida.writeObject(jsonResposta.toString());
					}
				} else {
					JSONObject jsonResposta = new JSONObject();
					jsonResposta.put("protocolo", "LOG-ERR");
					this.saida.writeObject(jsonResposta.toString());
				}
			} catch (Exception erro) {
					System.err.println(erro);
				}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + ((saida == null) ? 0 : saida.hashCode());
		result = prime * result + ((socket == null) ? 0 : socket.hashCode());
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
		Servidor other = (Servidor) obj;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		if (socket == null) {
			if (other.socket != null)
				return false;
		} else if (!socket.equals(other.socket))
			return false;
		return true;
	}
	
}
