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
import model.Usuario;

@WebFilter(urlPatterns = "*.adm")
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Usuario user = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("user");

		if (user != null && user.getAdmin()) {
			chain.doFilter(request, response);

		} else {
			request.setAttribute("flash", "No tienes los permisos necesarios");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
	}

}
