package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crm.to.PlateTO;
import crm.to.SubAdminTO;
import dao.PlateDAO;
import dao.SubAdminDAO;

/**
 * Servlet implementation class ModifyPlate
 */
public class ModifyPlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPlate() {
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
		PlateTO plate=new PlateTO();
		PlateDAO Platedao=new PlateDAO();
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher=null;
		
		plate.setPlate_Id(Integer.parseInt(request.getParameter("plate_id")));
		
			boolean result;
			plate.setSize(request.getParameter("plate_size"));
			plate.setTotal_Plate(Integer.parseInt(request.getParameter("plate_total")));
			plate.setAvailable_Plate(Integer.parseInt(request.getParameter("plate_available")));
			plate.setRate_Per_Plate(Float.parseFloat(request.getParameter("plate_rate")));
			//System.out.println("the value we hav are"+subadmin.getSubadminAdd()+subadmin.getSubadminOffice());
			result=Platedao.modify(plate);
			if(result==true)
			{
				System.out.println("success");
				
			}
			dispatcher=request.getRequestDispatcher("SearchPlate.jsp");	
		
		dispatcher.forward(request, response);

	}

}
