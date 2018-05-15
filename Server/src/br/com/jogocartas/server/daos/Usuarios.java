package br.com.jogocartas.server.daos;

import org.json.JSONObject;

import br.com.jogocartas.server.bd.BD;
import br.com.jogocartas.server.core.MeuResultSet;
import br.com.jogocartas.server.dbos.Usuario;

/**
 * Classe responsavel por executar todas as operaçoes no banco de dados
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */
public class Usuarios {

	/**
	 * Esse metodo eh responsavel por verificar se um usuario 
	 * ja esta cadastrado no sistema
	 * 
	 * @param email: email do usuario que deseja verificar se esta cadastrado
	 * 
	 * @return true: caso o usuario esta cadastrado
	 *         false: caso o usuario nao esta cadastrado
	 * */
	public boolean isCadastrado(String email) throws Exception {
		boolean retorno = false;
		
			String sql;
			sql = "SELECT * FROM USUARIOS WHERE EMAIL = ?";
			BD.COMANDO.prepareStatement(sql);
			BD.COMANDO.setString(1, email);
			
			MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery();
			retorno = resultado.first();
			
		return retorno;
	}
	
	/**
	 * 
	 * Esse metodo eh responsavel por cadastrar um novo usuario no sistema
	 * 
	 * @param jsonUsuario: Usuario a ser cadastrado
	 * 
	 * 
	 * */
	public void incluir(JSONObject jsonUsuario) throws Exception {
		if(jsonUsuario == null)
			throw new Exception("Usuario não fornecido");
		
		String sql;
		sql = "INSERT INTO USUARIOS(EMAIL,NOME,SENHA,QTDMOEDAS)VALUES(?,?,?,?)";
		BD.COMANDO.prepareStatement(sql);
		BD.COMANDO.setString(1, jsonUsuario.getString("email").toString());
		BD.COMANDO.setString(2, jsonUsuario.getString("nome").toString());
		BD.COMANDO.setString(3, jsonUsuario.getString("senha").toString());
		BD.COMANDO.setInt(4,  jsonUsuario.getInt("qtdmoedas"));
		
		BD.COMANDO.executeUpdate();
		BD.COMANDO.commit();
		
	}
	
	/**
	 * Esse metodo eh responsavel por alterar os dados de um usuario cadastro no sistema
	 * 
	 * @param usuario: Uusario a ser alterado no sistema
	 * 
	 * */
	public void alterar(Usuario usuario) throws Exception{
		if(usuario == null)
			throw new Exception("Usuario não fornecido");
		
		if(!isCadastrado(usuario.getEmail()))
			throw new Exception ("Nao cadastrado");
		
		String sql;
		sql = "UPDATE USUARIOS SET NOME=? SENHA=? WHERE EMAIL=?";
		BD.COMANDO.prepareStatement(sql);
		BD.COMANDO.setString(1, usuario.getNome());
		BD.COMANDO.setString(2, usuario.getSenha());
		BD.COMANDO.setString(3, usuario.getEmail());
		BD.COMANDO.executeUpdate();
		BD.COMANDO.commit();
		
	}
	
	/**
	 * Esse metodo eh responsavel por pegar os dados de um determinado usuario
	 * 
	 * @param email: Email do usuario que deseja pegar os dados
	 * 
	 * @return usuario: dados do usuario pesquisado
	 * */
	public Usuario getUsuario(String email) throws Exception {
		Usuario usuario = null;
		String sql;
		sql = "SELECT * FROM USUARIOS WHERE EMAIL=?";
		BD.COMANDO.prepareStatement(sql);
		BD.COMANDO.setString(1, email);
		MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery();
		if(!resultado.first())
			throw new Exception ("Não cadastrado");
		
		usuario = new Usuario(resultado.getString("EMAIL"),resultado.getString("NOME"),resultado.getString("SENHA"));
		
		return usuario;
	}
	
	/**
	 * 
	 * Esse metodo eh responsavel por retornar todos os usuarios cadastrado no banco
	 * 
	 * @return MeuResultSert: resultado do select na tabela usuario
	 * */
	public MeuResultSet getUsuarios() throws Exception{
		String sql = "SELECT * FROM USUARIOS";
		BD.COMANDO.prepareStatement(sql);
		MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery();
		return resultado;
	}
}
