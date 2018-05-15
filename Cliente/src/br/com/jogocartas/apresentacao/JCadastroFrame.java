package br.com.jogocartas.apresentacao;

import java.awt.Component;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.jogocartas.comunicacao.Transmissao;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

/**
 * Essa classe eh responsavel por criar a Tela de Cadastro
 * do Sistema de Cartas
 * 
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */
public class JCadastroFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_email;
	private JPasswordField txt_senha;
	private JPasswordField txt_confirmacao;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroFrame frame = new JCadastroFrame();
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
	public JCadastroFrame() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 25, 66, 30);
		contentPane.add(lblNewLabel);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		btnCancelar.setBounds(238, 197, 140, 40);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("OK");
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		btnCadastrar.setBounds(22, 197, 140, 40);
		contentPane.add(btnCadastrar);

		/**
		 * Esse metodo eh responsavel por efetuar o cadastro 
		 * do usuario no sistema
		 * 
		 * @rule: todo usuario cadastrado no sistema inicia-se com 1000 moedas
		 * */	
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txt_nome.getText();
				String email = txt_email.getText();
				String senha = new String(txt_senha.getPassword());
				String confirmacao = new String(txt_confirmacao.getPassword());

				// valida se os campos não foram preenchidos
				// valida se o campo senha eh igual ao campo confirmacao
				// valida se o email preenchido eh um email valido
				if ((nome.length() == 0) || (email.length() == 0) || (senha.length() == 0)
						|| (confirmacao.length() == 0)) {
					JOptionPane.showMessageDialog(frame, "Você não pode deixar campos vazios!");
				} else if (!senha.equals(confirmacao)) {
					JOptionPane.showMessageDialog(frame, "As senhas não coincidem!");
				} else if (!validar(email)) {
					JOptionPane.showMessageDialog(frame, "E-mail inválido!");
				} else {
					
					JSONObject jsonObject = new JSONObject();
					try {
						
						jsonObject.put("protocolo", "CAD");
						jsonObject.put("nome", nome);
						jsonObject.put("email", email);
						jsonObject.put("senha", senha);
						jsonObject.put("confirmacao", confirmacao);
						jsonObject.put("qtdmoedas", 1000); // todo novo usuario cadastrado no sistema inicia-se com 1000 moedas
						
						Transmissao transmitor = new Transmissao(jsonObject);
						
						if (transmitor.enviaSolicitacao().getString("protocolo").equals("CAD-SUCC")) { // validando se o protocolo enviado pelo servidor eh SUCC-LOG
							JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!");
							JLoginFrame form_login = new JLoginFrame();
							form_login.setLocationRelativeTo(null);
							form_login.setVisible(true);
							dispose();
						}else {
							
							JOptionPane.showMessageDialog(frame, "Erro ao cadastrar, tente novamente!");
						}
						
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		/**
		 * Esse metodo eh responsavel por limpar os dados
		 * dos campos preenchido pelo usuario
		 * */
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLoginFrame form_login = new JLoginFrame();
				form_login.setLocationRelativeTo(null);
				form_login.setVisible(true);

				dispose();
			}
		});

		JLabel lblSenha = new JLabel("E-MAIL:");
		lblSenha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblSenha.setBounds(12, 70, 78, 20);
		contentPane.add(lblSenha);

		txt_nome = new JTextField();
		txt_nome.setToolTipText("");
		txt_nome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		txt_nome.setColumns(10);
		txt_nome.setBounds(90, 27, 312, 30);
		contentPane.add(txt_nome);

		txt_email = new JTextField();
		txt_email.setToolTipText("");
		txt_email.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		txt_email.setColumns(10);
		txt_email.setBounds(90, 67, 312, 30);
		contentPane.add(txt_email);

		JLabel lblSenha_1 = new JLabel("SENHA:");
		lblSenha_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblSenha_1.setBounds(12, 110, 78, 30);
		contentPane.add(lblSenha_1);

		JLabel lblConfirmao = new JLabel("CONFIRMA\u00C7\u00C3O:");
		lblConfirmao.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblConfirmao.setBounds(12, 150, 155, 30);
		contentPane.add(lblConfirmao);

		txt_senha = new JPasswordField();
		txt_senha.setBounds(90, 110, 312, 30);
		contentPane.add(txt_senha);

		txt_confirmacao = new JPasswordField();
		txt_confirmacao.setBounds(162, 154, 240, 30);
		contentPane.add(txt_confirmacao);
	}

	public static boolean validar(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentPane == null) ? 0 : contentPane.hashCode());
		result = prime * result + ((frame == null) ? 0 : frame.hashCode());
		result = prime * result + ((txt_confirmacao == null) ? 0 : txt_confirmacao.hashCode());
		result = prime * result + ((txt_email == null) ? 0 : txt_email.hashCode());
		result = prime * result + ((txt_nome == null) ? 0 : txt_nome.hashCode());
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
		JCadastroFrame other = (JCadastroFrame) obj;
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
		if (txt_confirmacao == null) {
			if (other.txt_confirmacao != null)
				return false;
		} else if (!txt_confirmacao.equals(other.txt_confirmacao))
			return false;
		if (txt_email == null) {
			if (other.txt_email != null)
				return false;
		} else if (!txt_email.equals(other.txt_email))
			return false;
		if (txt_nome == null) {
			if (other.txt_nome != null)
				return false;
		} else if (!txt_nome.equals(other.txt_nome))
			return false;
		if (txt_senha == null) {
			if (other.txt_senha != null)
				return false;
		} else if (!txt_senha.equals(other.txt_senha))
			return false;
		return true;
	}

}
