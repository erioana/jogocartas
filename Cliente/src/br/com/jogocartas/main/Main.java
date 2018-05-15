package br.com.jogocartas.main;

import br.com.jogocartas.apresentacao.JLoginFrame;

/**
 * Classe principal do sistema de cartas
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */
public class Main {

	public static void main(String[] args) {
		
		JLoginFrame telaLogin = new JLoginFrame();
		telaLogin.setLocationRelativeTo(null);
		telaLogin.setVisible(true);
		
	}
}
