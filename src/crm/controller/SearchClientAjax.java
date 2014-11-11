package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import crm.to.ClientTO;
import crm.to.SubAdminTO;
import dao.ClientDAO;
import dao.SubAdminDAO;

/**
 * Servlet implementation class SearchClientAjax
 */
public class SearchClientAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClientAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside controller");
		ClientTO client=new ClientTO();
		ClientDAO clientDAO=new ClientDAO();
		HttpSession session = request.getSession(true);
		String result=null;
		RequestDispatcher dispatcher=null;
		System.out.println("the value through input"+request.getParameter("delete"));
		System.out.println("the value found is"+request.getParameter("subadmin_id"));
		client.setClient_id(Integer.parseInt(request.getParameter("client_id")));
		result=clientDAO.Fetchresult(client);
		System.out.println("inside controller 1");
		//request.setAttribute("subadmin", subadmin);
		System.out.println("inside controller 2");
		
		//dispatcher=request.getRequestDispatcher("crmShowSubadmin.jsp");	
		System.out.println("inside controller 3");
		
		
		//request.setAttribute("subadmin",subadmin);
		System.out.println("inside controller 4");
		//System.out.println("the name is"+subadmin.getSubadminName()+subadmin.getSubadminAdd());
		
				
		response.setContentType("text/plain");  
		  response.setCharacterEncoding("UTF-8"); 
		  response.getWriter().write(result); 

	}

}
