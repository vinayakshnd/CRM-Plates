package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.to.OfficeTO;
import crm.to.PlateTO;
import dao.OfficeDAO;
import dao.PlateDAO;

/**
 * Servlet implementation class AddPlate
 */
public class AddPlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlate() {
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
		String generate_off_id=null;
		int result=0;
		
		System.out.println(generate_off_id+"done");
		RequestDispatcher dispatcher=null;
		
		//plate.setPlate_Id(Integer.parseInt(request.getParameter);
		plate.setSize(request.getParameter("plate_size"));
		plate.setTotal_Plate(Integer.parseInt(request.getParameter("total_plate")));
		plate.setAvailable_Plate(Integer.parseInt(request.getParameter("avail_plate")));
		plate.setRate_Per_Plate(Float.parseFloat(request.getParameter("rate_per_plate")));
		result=Platedao.addresult(plate);
		
		//if(result==true)
		{
			System.out.println("success");
			
		}
		dispatcher=request.getRequestDispatcher("AddPlate.jsp");	
	
	dispatcher.forward(request, response);

	}

}
