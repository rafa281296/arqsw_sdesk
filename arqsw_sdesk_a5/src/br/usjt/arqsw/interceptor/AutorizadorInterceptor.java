package br.usjt.arqsw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object controller) throws Exception {
		String uri = request.getRequestURI();
		if(uri.endsWith("LoginForm") || uri.endsWith("efetua_login") ||
				uri.contains("css") || uri.contains("js") ||
				uri.contains("img")){
				return true;
				}
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("LoginForm");
	return false;
	}

}
