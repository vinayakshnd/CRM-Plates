package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import crm.to.UserTO;
import dao.UserDAO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO userdao=new UserDAO();
		UserTO userto=new UserTO();
		 HttpSession session = request.getSession(true);
		boolean result;
		System.out.println("inside controller");
		String username=request.getParameter("user_id");
		String password=request.getParameter("password");
		userto.setUsername(username);
		userto.setPassword(password);
		System.out.println(userto.getUsername()+"    "+userto.getPassword());
		result=userdao.uservalidate(userto);
		RequestDispatcher dispatcher = null;
		if(result)
		{
			dispatcher = request
					.getRequestDispatcher("Login.jsp");
			session.setAttribute("user",username);
			request.setAttribute("done","success");
		}
		else
		{
			request.setAttribute("done","failed");
			
			dispatcher=request.getRequestDispatcher("Login.jsp");
		}
		dispatcher.forward(request, response);
	}

}
