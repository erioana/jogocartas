package br.com.jogocartas.comunicacao;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.net.Socket;

import org.json.JSONObject;
/**
 * 
 * Essa classe eh responsavel por efeturar a conexao com o Servidor e trasnmitir os dados enviado pelo Cliente
 * 
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 2.0.0
 *
 */
public class Transmissao {

	private JSONObject jsonObject;
	
	/**
	 * Método construtor que recebe como parametro um objeto da classe Solicitacao
	 * @param solicitacao
	 */
	public Transmissao(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	/**
	 * Esse metodo eh responsavel por fazer o envio dos dados (objeto json) para o Servidor
	 * 
	 * O servidor retornara um objeto json como resposta
	 * 
	 * */
	public JSONObject enviaSolicitacao() {
		JSONObject jsonRetorno = null;
		try {
			Socket connection = new Socket("192.168.15.7", 763);
			ObjectOutputStream transmissor = new ObjectOutputStream(connection.getOutputStream());
			ObjectInputStream receptor = new ObjectInputStream(connection.getInputStream());
			transmissor.writeObject(this.jsonObject.toString());
			transmissor.flush();
			
			String retorno = String.valueOf(receptor.readObject());
			jsonRetorno = new JSONObject(retorno.toString()); 
			
		} catch (Exception erro) {
				System.err.println(erro.getMessage());
			}
		return jsonRetorno;
	}
}
