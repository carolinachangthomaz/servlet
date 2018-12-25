package br.com.carolina.bean;

import br.com.carolina.utilitarios.Conexao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.carolina.utilitarios.*;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

    private String usuario;
    private String senha;
    private String nivelAcesso;
    private String situacao = "";
    
	public Usuario() {
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
    
	
    public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void gravarLogin(){
    	
	   	 Conexao conexao = new Conexao();
	   	 conexao.conecta();
	   	 String sql = "INSERT INTO login (log_usuario, log_senha, log_nivelacesso) values (?, ?, ?); ";
	   	 try {
			PreparedStatement ps = conexao.connection.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, senha);
			ps.setString(3, nivelAcesso);
			
			ps.executeUpdate();
			System.out.println("gravado: ");
			this.situacao = "Usuario "+usuario+ " foi inserido com sucesso";
			
		} catch (SQLException e) {
			System.out.println("Erro ao gravars: "+e);
			this.situacao = "Usuario "+usuario+ " Não foi cadastrado";
		}
   	 
    }
	
	
	public boolean logar(){
    	boolean result = false;
	   	 Conexao conexao = new Conexao();
	   	 conexao.conecta();
	   	 String sql = "SELECT log_usuario, log_senha from login WHERE log_usuario like '"+usuario+"' and log_senha like '"+senha+"'";
	   	 try {
					
	   		 conexao.resultset = conexao.statement.executeQuery(sql);
	   		 
	   		 if(conexao.resultset.next()){
	   			 result = true;
	   		 }
	   		 
		} catch (SQLException e) {
			System.out.println("Erro ao gravars: "+e);
			this.situacao = "Usuario "+usuario+ " Não foi cadastrado";
		}
		return result;
  	 
   }
}
