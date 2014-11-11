package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.to.ClientTO;
import crm.to.OfficeTO;
import dao.ClientDAO;
import dao.OfficeDAO;

/**
 * Servlet implementation class AddClient
 */
public class AddClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClient() {
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
		String generate_off_id=null;
		boolean result=true;
		
		System.out.println(generate_off_id+"done");
		RequestDispatcher dispatcher=null;
		String c=null;
		long id=System.currentTimeMillis();
		//client.setClient_id(Long.toString(id));
		System.out.println(client.getClient_id());
		client.setClient_name(request.getParameter("client_name"));
		client.setClient_add(request.getParameter("client_add"));	
		client.setClient_phn(request.getParameter("client_phn"));
		client.setClient_site_add(request.getParameter("client_site_add"));
		client.setGuaranter_name(request.getParameter("guaranter_name"));
		client.setGuaranter_phn(request.getParameter("guaranter_phn"));
		
		clientDAO.addClient(client);
		
		dispatcher=request.getRequestDispatcher("AddClient.jsp");	
		
	dispatcher.forward(request, response);

	}

}
