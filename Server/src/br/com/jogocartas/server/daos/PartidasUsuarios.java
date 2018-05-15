package br.com.jogocartas.server.daos;

import java.util.ArrayList;
import java.util.List;

import br.com.jogocartas.server.bd.BD;
import br.com.jogocartas.server.core.MeuResultSet;
import br.com.jogocartas.server.dbos.PartidaUsuario;
import br.com.jogocartas.server.dbos.Usuario;

/**
 * Classe responsavel por executar todas as operaçoes no banco de dados
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */
public class PartidasUsuarios {

	/**
	 * Esse metodo eh responsavel verificar se um usuario ja esta cadastrado na partida  
	 * 
	 * @param usuarioID: id do usuario que deseja se cadastrar na partida
	 *        partidaID: id da partida que deseja verificar se o usuario ja esta
	 * 
	 * @return true: caso o usuario esta cadastrado na partida
	 *         false: caso o usuario nao esta cadastrado na partida
	 * */
	public boolean isCadastrado(int usuarioID, int partidaID) throws Exception {
		boolean retorno = false;
		
			/*String sql;
			sql = "SELECT * FROM USUARIOS WHERE EMAIL = ?";
			BD.COMANDO.prepareStatement(sql);
			BD.COMANDO.setString(1, email);
			
			MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery();
			retorno = resultado.first();*/
			
		return retorno;
	}
	
	/**
	 * 
	 * Esse metodo eh responsavel por incluir um usuario na partida
	 * 
	 * @param usuarioID: id do usuario que deseja entrar na partida
	 * @param partidaID: id da partida que o usuario quer entrar
	 * 
	 * */
	public void incluirUsuarioNaPartida(int usuarioID, int partidaID) throws Exception {
		/*if(usuario == null)
			throw new Exception("Usuario não fornecido");
		
		String sql;
		sql = "INSERT INTO USUARIOS(EMAIL,NOME,SENHA)VALUES(?,?,?)";
		BD.COMANDO.prepareStatement(sql);
		BD.COMANDO.setString(1, usuario.getEmail());
		BD.COMANDO.setString(2, usuario.getNome());
		BD.COMANDO.setString(3, usuario.getSenha());
		
		BD.COMANDO.executeUpdate();
		BD.COMANDO.commit();*/
		
	}
	
	/**
	 * Esse metodo eh responsavel por remover um usuario de uma partida
	 * quando o mesmo desejar sair da partida
	 * 
	 * @param usuario: Usario a ser alterado no sistema
	 * 
	 * */
	public void removerUsuarioDaPartida(int usuarioID, int partidaID) throws Exception{
		
		/**
		 * Implementar metodo
		 * 
		 * */
	}
	
	/**
	 * Esse metodo eh responsavel por retornar as informações de cada partida: 
	 * informações de usuario e da partida que ele se encontra
	 * 
	 * 
	 * @return partidasUsuario list: lista de cada PartidaUsuario cadastrar no banco
	 * */
	public List<PartidaUsuario> getPartidasByUsuario() throws Exception {
		List<PartidaUsuario> partidaUsuarioList = new ArrayList();
		String sql;
		sql = "SELECT partidasusuarios.partidas_id, partidas.nomepartida, " + 
		              "partidas.valoraposta, usuarios.id as usuario_id, "    + 
				      "usuarios.nome as nome_usuario " +
		      "FROM partidasusuarios, partidas, usuarios " + 
			  "WHERE partidasusuarios.partidas_id = partidas.id" + 
		      "AND partidasusuarios.usuarios_id = usuarios.id;";
		
		BD.COMANDO.prepareStatement(sql);
		MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery();
		while(resultado.next()){
			PartidaUsuario partidasUsuario = new PartidaUsuario();
			partidasUsuario.setPartidaID(resultado.getInt("partidas_id"));
			partidasUsuario.setNomePartida(resultado.getString("nomepartida"));
			partidasUsuario.setValorPartida(resultado.getDouble("valoraposta"));
			partidasUsuario.setUsuarioID(resultado.getInt("usuario_id"));
			partidasUsuario.setNomeUsuario(resultado.getNString("nome_usuario"));
			
			partidaUsuarioList.add(partidasUsuario);
		}

		return partidaUsuarioList;
	}
}