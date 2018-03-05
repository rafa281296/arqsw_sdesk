package test;

import java.io.IOException;
import java.util.ArrayList;

import entity.Fila;
import service.FilaService;

public class TestFila {

	public static void main(String[] args) {
		FilaService service = new FilaService();
		try {
			ArrayList<Fila> filas = service.listarFilas();
			for(Fila fila:filas) {
				System.out.println(fila);
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
