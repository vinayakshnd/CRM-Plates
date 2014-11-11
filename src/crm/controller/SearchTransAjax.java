package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crm.to.SubAdminTO;
import crm.to.TransMaster;
import dao.SubAdminDAO;
import dao.TransactionDAO;

/**
 * Servlet implementation class SearchTransAjax
 */
public class SearchTransAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTransAjax() {
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
		TransMaster Trans=new TransMaster();
		TransactionDAO Transactiondao=new TransactionDAO();
		HttpSession session = request.getSession(true);
		String result1=null;
		RequestDispatcher dispatcher=null;
		System.out.println("the value through input"+request.getParameter("delete"));
		System.out.println("the value found is"+request.getParameter("subadmin_id"));
		Trans.setClient_id(Integer.parseInt(request.getParameter("client_id")));
		//if(request.getParameter("chkcontrol").equals("1"))
				{
		
		result1=Transactiondao.Fetchresult(Trans);
		System.out.println("inside controller 1");
		//request.setAttribute("subadmin", subadmin);
		System.out.println("inside controller 2");
		
		//dispatcher=request.getRequestDispatcher("crmShowSubadmin.jsp");	
		System.out.println("inside controller 3");
		
		
		//request.setAttribute("subadmin",subadmin);
		System.out.println("inside controller 4");
		System.out.println("the name is"+Trans.getSubadmin_id());
		
				}
		response.setContentType("text/plain");  
		  response.setCharacterEncoding("UTF-8"); 
		  response.getWriter().write(result1); 
	}

	}

