package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
import br.usjt.arqsw.service.UsuarioService;
/**
 * 
 * @author asbonato
 *
 */
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;
	private UsuarioService usuarioService;
	
	
	@Autowired
	public ManterChamadosController(FilaService filaService, ChamadoService chamadoService, UsuarioService usuarioService) {
		this.filaService =  filaService;
		this.chamadoService =  chamadoService;
		this.usuarioService = usuarioService;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	@RequestMapping("/efetua_login")
	public String efetuarlogin(@Valid Usuario usuario, HttpSession session) throws Throwable  {
			if(usuarioService.carrega(usuario)) {
				session.setAttribute("usuarioLogado", usuario);
				return "ChamadoListar";
			}else {
				
			}
			
		return "LoginForm";
		
		
	}
	@RequestMapping("/LoginForm")
	public String loginForm(Model model) throws IOException{
		return "LoginForm";
	}
	
//	@RequestMapping("/LoginForm")
//	public String efetuarLogin(Usuario u, HttpSession session,Model model) throws Throwable{
//		session.setAttribute("usuarioLogado");
//		return "ChamadoListar";
//	}

	
	
	/**
	 * 
	 * @param model Acesso à request http
	 * @return JSP de Listar Chamados
	 */
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoListar";
				//return "redirect:listar_filas_exibir";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);

			// TODO Código para carregar os chamados
			ArrayList<Chamado> chamados = chamadoService.listarChamados(fila);
			model.addAttribute("chamados", chamados);
			
			return "ChamadoListarExibir";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

}
