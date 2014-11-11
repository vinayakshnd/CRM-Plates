package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crm.to.OfficeTO;
import crm.to.SubAdminTO;
import dao.OfficeDAO;
import dao.SubAdminDAO;

/**
 * Servlet implementation class ModifyOffice
 */
public class ModifyOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOffice() {
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
		OfficeTO office=new OfficeTO();
		OfficeDAO Officedao=new OfficeDAO();
		//HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher=null;
		//System.out.println("the value through input"+request.getParameter("delete"));
		System.out.println("the value found is"+request.getParameter("subadmin_id"));
		office.setOffice_Id(Integer.parseInt(request.getParameter("office_id")));
		
			boolean result;
			office.setOffice_Name(request.getParameter("office_name"));
			office.setOffice_Add(request.getParameter("office_add"));
			office.setOffice_Phn(request.getParameter("office_phn"));
			result=Officedao.modify(office);
			if(result==true)
			{
				System.out.println("success");
				
			}
			dispatcher=request.getRequestDispatcher("SearchOffice.jsp");	
		
		dispatcher.forward(request, response);
	



	}

}
