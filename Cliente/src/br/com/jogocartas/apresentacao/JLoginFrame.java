package br.com.jogocartas.apresentacao;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.jogocartas.comunicacao.Solicitacao;
import br.com.jogocartas.comunicacao.Transmissao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Essa classe eh responsavel por criar a Tela de Login
 * do Sistema de Cartas
 * 
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */
public class JLoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txt_email;
	private JPasswordField txt_senha;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLoginFrame frame = new JLoginFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLoginFrame() {

		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_email = new JTextField();
		txt_email.setToolTipText("");
		txt_email.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		txt_email.setBounds(103, 32, 363, 30);
		contentPane.add(txt_email);
		txt_email.setColumns(10);

		JLabel lblNewLabel = new JLabel("E-MAIL:");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(22, 31, 82, 30);
		contentPane.add(lblNewLabel);

		/**
		 * 
		 * Metodo eh responsavel por efetuar o login do usuario
		 * no sistema
		 * 
		 * */
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		btnEntrar.setBounds(22, 154, 140, 40);
		contentPane.add(btnEntrar);
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txt_email.getText();
				String pass = new String(txt_senha.getPassword());

				Solicitacao solicitacao = new Solicitacao("LOG",email, pass);
				Transmissao transmitor = new Transmissao(solicitacao);
				
				if (transmitor.enviaSolicitacao().equals("LOG-SUC")) {
					JOptionPane.showMessageDialog(frame,
							"Logado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(frame,
							"E-mail ou senha inválido, por favor tente novamente!");
				}
			}
		});
		

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		btnCancelar.setBounds(174, 154, 140, 40);
		contentPane.add(btnCancelar);
		
		/**
		 * 
		 * Esse metodo eh responsavel por limpar os campos
		 * preenchidos pelo usuario do sistema
		 * 
		 * */
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_email.setText("");
				txt_senha.setText("");
			}

		});

		JButton btnCadastro = new JButton("Cadastrar-se");
		btnCadastro.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		btnCadastro.setBounds(326, 154, 140, 40);
		contentPane.add(btnCadastro);
		
		/**
		 * 
		 * Esse metodo eh responsavel por abrir a tela de cadastro
		 * para um novo usuario ser cadastrado no sistema
		 * 
		 * */
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroFrame form_cadastro = new JCadastroFrame();
				dispose();
				form_cadastro.setLocationRelativeTo(null);
				form_cadastro.setVisible(true);

			}
		});
		

		txt_senha = new JPasswordField();
		txt_senha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		txt_senha.setBounds(103, 94, 363, 30);
		contentPane.add(txt_senha);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblSenha.setBounds(22, 93, 82, 30);
		contentPane.add(lblSenha);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentPane == null) ? 0 : contentPane.hashCode());
		result = prime * result + ((frame == null) ? 0 : frame.hashCode());
		result = prime * result + ((txt_email == null) ? 0 : txt_email.hashCode());
		result = prime * result + ((txt_senha == null) ? 0 : txt_senha.hashCode());
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
		JLoginFrame other = (JLoginFrame) obj;
		if (contentPane == null) {
			if (other.contentPane != null)
				return false;
		} else if (!contentPane.equals(other.contentPane))
			return false;
		if (frame == null) {
			if (other.frame != null)
				return false;
		} else if (!frame.equals(other.frame))
			return false;
		if (txt_email == null) {
			if (other.txt_email != null)
				return false;
		} else if (!txt_email.equals(other.txt_email))
			return false;
		if (txt_senha == null) {
			if (other.txt_senha != null)
				return false;
		} else if (!txt_senha.equals(other.txt_senha))
			return false;
		return true;
	}	
}
