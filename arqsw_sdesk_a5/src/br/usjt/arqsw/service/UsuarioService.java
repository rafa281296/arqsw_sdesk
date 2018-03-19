package br.usjt.arqsw.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Usuario;

	
@Service
public class UsuarioService {
		private UsuarioDAO dao;
		@Autowired
		public UsuarioService(UsuarioDAO dao) {
			this.dao = dao;
		}
		
		public boolean carrega (Usuario usuario) throws Throwable{
			return dao.carregar(usuario);
		}

}
