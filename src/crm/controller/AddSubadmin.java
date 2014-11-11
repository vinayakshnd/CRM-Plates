package crm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.to.PlateTO;
import crm.to.SubAdminTO;
import crm.to.UserTO;
import dao.PlateDAO;
import dao.SubAdminDAO;

/**
 * Servlet implementation class AddSubadmin
 */
public class AddSubadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubadmin() {
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
		SubAdminTO subadmin=new SubAdminTO();
		UserTO user = new UserTO();
		SubAdminDAO Subadmindao=new SubAdminDAO();
		String generate_off_id=null;
		int result=0;
		String message="";
		//System.out.println(generate_off_id+"done");
		RequestDispatcher dispatcher=null;
		
		
		subadmin.setSubadminAdd(request.getParameter("subadmin_add"));
		subadmin.setSubadminName(request.getParameter("subadmin_name"));
		subadmin.setSubadminOffice(Integer.parseInt(request.getParameter("office_id")));
		System.out.println(subadmin.getSubadminOffice()+"key");
		subadmin.setSubadminPhn(request.getParameter("subadmin_phn"));
		
		user.setUsername(subadmin.getSubadminName());
		user.setPassword(request.getParameter("password"));
		
		try {
			result=Subadmindao.addresult(subadmin,user);
			if(result==2)
			{
				message="Record Added Successfully";
				
			}
			if(result==1)
			{
				message="Please select Different User Id";
				request.setAttribute("name",subadmin.getSubadminName());
				request.setAttribute("add",subadmin.getSubadminAdd());
				request.setAttribute("phn",subadmin.getSubadminPhn());
				request.setAttribute("office",subadmin.getSubadminOffice());
				
			}
			request.setAttribute("message", message);
			dispatcher=request.getRequestDispatcher("AddSubAdmin.jsp");	
			dispatcher.forward(request, response);
		}
	catch (SQLException e0) {
		// TODO Auto-generated catch block
		e0.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	}


