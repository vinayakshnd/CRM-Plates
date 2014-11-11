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
 * Servlet implementation class ModifyClient
 */
public class ModifyClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyClient() {
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
		RequestDispatcher dispatcher=null;
		//System.out.println("the value through input"+request.getParameter("delete"));
		System.out.println("the value found is"+request.getParameter("client_id"));
		client.setClient_id(Integer.parseInt(request.getParameter("client_id")));
		client.setClient_name(request.getParameter("client_name"));
		client.setClient_add(request.getParameter("client_add"));	
		client.setClient_phn(request.getParameter("client_phn"));
		client.setClient_site_add(request.getParameter("client_site_add"));
		client.setGuaranter_name(request.getParameter("guaranter_name"));
		client.setGuaranter_phn(request.getParameter("guaranter_phn"));
		boolean result;
		result=clientDAO.modify(client);
		if(result==true)
		{
			System.out.println("success");
		}
		dispatcher=request.getRequestDispatcher("SearchClient.jsp");	
		
		dispatcher.forward(request, response);
	}

}
