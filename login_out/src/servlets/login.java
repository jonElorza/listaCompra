package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesoDatos.AccesoDatosException;
import accesoDatos.Dao;
import modelo.Usuarios;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public login() {
        super();  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Usuarios> usuarios = Dao.obtenerTodas();
		} catch (AccesoDatosException e) {
			
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.sendRedirect("principal.jsp");
		
		try {
			Dao.insertar(new Usuarios(0, userName, email, password));
		} catch (AccesoDatosException e) {
			e.printStackTrace();
		}
		
		
	}

}
