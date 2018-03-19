package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.entity.Usuario;
/**
 * 
 * @author asbonato
 *
 */

@Repository
public class UsuarioDAO {
	private Connection conn;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		} catch (SQLException e){
			throw new IOException(e);
		}
	}
	
	public boolean carregar(Usuario usuario) throws IOException {
		boolean usuarioLogado = false;
		
		String query = "select * from USUARIO where username=? and password=?";

		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, usuario.getUsername());
			pst.setString(2, usuario.getPassword());
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					usuarioLogado = true;
				} else {
					usuarioLogado = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return usuarioLogado;
	}

}