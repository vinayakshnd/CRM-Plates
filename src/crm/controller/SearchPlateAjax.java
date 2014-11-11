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
 * Servlet implementation class SearchPlateAjax
 */
public class SearchPlateAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPlateAjax() {
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
			String result=null;
			RequestDispatcher dispatcher=null;
			
			plate.setPlate_Id(Integer.parseInt(request.getParameter("plate_id")));
			System.out.println(plate.getPlate_Id());
			//if(request.getParameter("chkcontrol").equals("1"))
					{
			
			result=Platedao.Fetchresult(plate);
			System.out.println("inside controller 1");
			//request.setAttribute("subadmin", subadmin);
			System.out.println("inside controller 2");
			
			//dispatcher=request.getRequestDispatcher("crmShowSubadmin.jsp");	
			System.out.println("inside controller 3");
			
			
			//request.setAttribute("subadmin",subadmin);
			System.out.println("inside controller 4");
			//System.out.println("the name is"+subadmin.getSubadminName()+subadmin.getSubadminAdd());
			
					}
			response.setContentType("text/plain");  
			  response.setCharacterEncoding("UTF-8"); 
			  response.getWriter().write(result); 
	
	}

}
