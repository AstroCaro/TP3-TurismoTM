package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "")
public class LoggedFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String usuario = (String) ((HttpServletRequest) request).getSession().getAttribute("username");
		
		if (usuario != null && usuario != "") {
			chain.doFilter(request, response); // la cadena debe continuar
		} else {
			request.setAttribute("flash", "Ingresa al sistema, antes de continuar");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp"); //le pido al contexto del servelt que me lleva a donde quiero direccionar
			dispatcher.forward(request, response);//en camino
		}
	}

}
