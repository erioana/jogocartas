package br.com.jogocartas.server.main;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe principal do servidor do sistema de cartas
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */

public class Main {
	
	public static void main(String args[]) throws IOException {

		ServerSocket receptor = new ServerSocket(763);
		
		System.out.println("Servidor iniciado!");
		
		while (true) {
			Socket conexao = null;
			try {
				conexao = receptor.accept();
				System.out.println("Novo cliente conectado!");

				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());

				System.out.println("Criando uma thread para este novo cliente...");

				Thread t = new Servidor(conexao, entrada, saida);
				t.start();

			} catch (Exception e) {
				conexao.close();
				e.printStackTrace();
			}
		}
	}
}
