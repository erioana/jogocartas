package br.com.jogocartas.server.bd;

import br.com.jogocartas.server.core.MeuPreparedStatement;
import br.com.jogocartas.server.daos.PartidasUsuarios;
import br.com.jogocartas.server.daos.Usuarios;

/**
 * Classe responsavel por configurar/setar as conexao com o banco de dados do servidor
 *
 * @author Andre Ribeiro, Gabriel Augusto, Vitor Malandrin
 * 
 * @version 1.0.0
 * 
 * */
public class BD {
	public static final MeuPreparedStatement COMANDO;
	public static final Usuarios USUARIOS;
	public static final PartidasUsuarios PARTIDAS_USUARIOS;

	static {
		MeuPreparedStatement comando = null;
		Usuarios usuarios = null;
		PartidasUsuarios partidasUsuarios = null;

		try {
				// mysql connection
	    		comando =
	            new MeuPreparedStatement (
	            "com.mysql.jdbc.Driver",
	            "jdbc:mysql://127.0.0.1:3306/jogocartas",
	            "root", "root");
	            
	            //sql connection
	            /**  
	               comando = new MeuPreparedStatement(
	               "com.microsoft.sqlserver.jdbc.SQLServerDriver",
	               "jdbc:sqlserver://fs5:1433;databasename=poo201846",
	               "poo201846", "Rdlyl9");
	            **/
			
			usuarios = new Usuarios();
		
		} catch (Exception erro) {
			System.err.println("Problemas de conexao com o BD");
			System.exit(0);
		}

		COMANDO = comando;
		USUARIOS = usuarios;
		PARTIDAS_USUARIOS = partidasUsuarios;
	}
}