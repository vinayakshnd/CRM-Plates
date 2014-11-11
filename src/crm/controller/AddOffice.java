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
 * Servlet implementation class Office
 */
public class AddOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOffice() {
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
		OfficeDAO officedao=new OfficeDAO();
		String generate_off_id=null;
		boolean result=true;
		
		System.out.println(generate_off_id+"done");
		RequestDispatcher dispatcher=null;
		
		office.setOffice_Name(request.getParameter("office_name"));
		office.setOffice_Add(request.getParameter("office_Add"));
		office.setOffice_Phn(request.getParameter("office_phn"));
		generate_off_id=request.getParameter("office_name").substring(0, 2);
		generate_off_id=generate_off_id.concat(office.getOffice_Phn().substring(8, 10));
		//office.setOffice_Id(generate_off_id);
		int officeId = officedao.addresult(office);
		
		//if(result==true)
		{
			System.out.println("success");
			
		}
		dispatcher=request.getRequestDispatcher("AddOffice.jsp");	
	
	dispatcher.forward(request, response);
			
	}

}
