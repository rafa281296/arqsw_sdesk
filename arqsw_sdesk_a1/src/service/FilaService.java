package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.FilaDAO;
import entity.Fila;

public class FilaService {
	private FilaDAO dao;
	
	public FilaService() {
		dao = new FilaDAO();
	}
	public ArrayList<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}

}
