package br.com.jogocartas.server.main;
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

import org.omg.CORBA.DataInputStream;

import br.com.jogocartas.server.bd.BD;
import br.com.jogocartas.server.dbos.Usuario;

/**
 * Classe representa o Servidor que executara todas as solicitacoes do Cliente
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
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
		String receber;

		while (true) {
			try {
				receber = String.valueOf(entrada.readObject());
				String user_data[] = new String[4];
				user_data = receber.split("/");

				if (user_data[0].equals("CAD")) {
							System.out.println("Nova Solicitação de Cadastro no servidor de:"+ user_data[1]);
							try {
								if (!BD.USUARIOS.isCadastrado(user_data[1])) {
									Usuario usuario = new Usuario(user_data[1], user_data[2], user_data[3]);
									BD.USUARIOS.incluir(usuario);
									String msg = "SUC";
									saida.writeObject(msg);
									
								}else {
									// RETORNA ERR, JA ESTÁ CADASTRADO
									
									String msg = "ERR";
									saida.writeObject(msg);
								}
		
							} catch (Exception erro) {
								System.err.println(erro);
							}
							this.socket.close();
							break;
				} else if (user_data[0].equals("LOG")) {
					System.out.println("Nova Solicitação de Cadastro no servidor de:"+ user_data[1]);
					if (BD.USUARIOS.isCadastrado(user_data[1])) {
						Usuario user = BD.USUARIOS.getUsuario(user_data[1]);
						if (user_data[2].equals(user.getSenha())) {
							String msg = "SUC";
							saida.writeObject(msg);
						} else {
							String msg = "ERR";
							saida.writeObject(msg);
						}
					} else {
						String msg = "ERR";
						saida.writeObject(msg);
					}
					this.socket.close();
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

		try {
			this.saida.close();

		} catch (IOException e) {
			e.printStackTrace();
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
