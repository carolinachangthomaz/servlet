package br.com.carolina.utilitarios;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {

	public Connection connection=null;
	public Statement statement=null;
	public ResultSet resultset=null;
	String acesso;
	String ordenacao;
	String driver = "org.postgresql.Driver";
    String url = "jdbc:postgresql://localhost/api-estoque";
    String usuario = "postgres";
    String senha   = "postgres"; 
	
	public boolean conecta() {
		boolean result = true;
		try {
			Class.forName(driver);	
			connection = DriverManager.getConnection(url, usuario, senha);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			System.out.println("conectou com sucesso");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Driver do BD não localizadoo: "+e);		
		 }catch (SQLException e) {
			 System.out.println("problema de dados: "+e);		
		  }
		return result;
	}
	
	public void desconecta() {
		try {
			statement.close();
			connection.close();
		} catch(Exception e) {
			System.out.println("Nao conseguiu fechar : "+e);
		}
		
	}
	
	
}
