package br.com.jogocartas.comunicacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Classe que faz a conexão com o Servidor, para transmitir as solicitaçoes de login e cadastro
 * @author Gabriel
 *
 */
public class Transmissao {

	private Solicitacao solicitacao;
	private String data_string;
	/**
	 * Método construtor que recebe como parametro um objeto da classe Solicitacao
	 * @param solicitacao
	 */
	public Transmissao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	/**
	 * Método que fará o envio da solicitação para o servidor, no caso se for
	 * para cadastrar irá enviar o comando CAD e os dados para cadastro
	 * Caso seja login enviará LOG com os dados email e senha
	 * Após o envio das informaçoes para o servidor, o mesmo retorna SUC para Sucesso, ou ERR para erro
	 * @return Retorna SUC para Sucesso na solicitaçao desejada e ERR para erro na solicitação desejada
	 */
	public String enviaSolicitacao() {
		String resp = "";
		try {
			Socket connection = new Socket("192.168.15.7", 763);
			String msg;
			ObjectOutputStream transmissor = new ObjectOutputStream(connection.getOutputStream());
			ObjectInputStream receptor = new ObjectInputStream(connection.getInputStream());
			if (this.solicitacao.getProtocolo().equals("CAD")) {
				data_string = this.solicitacao.getProtocolo()+ "/" + this.solicitacao.getComplemento1() + "/" + this.solicitacao.getComplemento2()
						+ "/" + this.solicitacao.getComplemento3();

			} else if (this.solicitacao.getProtocolo().equals("LOG")) {
				data_string = this.solicitacao.getProtocolo() + "/" + this.solicitacao.getComplemento1() + "/" + this.solicitacao.getComplemento2();

			}

			transmissor.writeObject(data_string);
			transmissor.flush();

			while (true) {
				String pedido;
				pedido = String.valueOf(receptor.readObject());
				if (this.solicitacao.getProtocolo().equals("CAD")) {
					if (pedido.equals("SUC")) {
						resp = "CAD-SUC";
						break;
					} else {
						resp = "CAD-ERR";
						break;
					}
				} else if (this.solicitacao.getProtocolo().equals("LOG")) {
					if (pedido.equals("SUC")) {
						resp = "LOG-SUC";
						break;
					} else {
						resp = "LOG-ERR";
						break;
					}
				}

			}
		} catch (Exception erro) {
			System.err.println(erro.getMessage());
		}
		return resp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_string == null) ? 0 : data_string.hashCode());
		result = prime * result + ((solicitacao == null) ? 0 : solicitacao.hashCode());
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
		Transmissao other = (Transmissao) obj;
		if (data_string == null) {
			if (other.data_string != null)
				return false;
		} else if (!data_string.equals(other.data_string))
			return false;
		if (solicitacao == null) {
			if (other.solicitacao != null)
				return false;
		} else if (!solicitacao.equals(other.solicitacao))
			return false;
		return true;
	}
}
