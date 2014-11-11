package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubAdminDAO;
import crm.to.SubAdminTO;

/**
 * Servlet implementation class CrmSeachSubadmin
 */
public class CrmSeachSubadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrmSeachSubadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside controller");
		SubAdminTO subadmin=new SubAdminTO();
		SubAdminDAO subadmindao=new SubAdminDAO();
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher=null;
		System.out.println("the value through input"+request.getParameter("delete"));
		System.out.println("the value found is"+request.getParameter("subadmin_id"));
		subadmin.setSubadminId(request.getParameter("subadmin_id"));
		/*if(request.getParameter("chkcontrol").equals("1"))
				{
		
		subadmin=subadmindao.Fetchresult(subadmin);
		System.out.println("inside controller 1");
		request.setAttribute("subadmin", subadmin);
		System.out.println("inside controller 2");
		
		dispatcher=request.getRequestDispatcher("crmShowSubadmin.jsp");	
		System.out.println("inside controller 3");
		
		
		request.setAttribute("subadmin",subadmin);
		System.out.println("inside controller 4");
		System.out.println("the name is"+subadmin.getSubadminName()+subadmin.getSubadminAdd());
		
				}
		*///else
		{
			boolean result;
			subadmin.setSubadminName(request.getParameter("subadmin_name"));
			subadmin.setSubadminAdd(request.getParameter("subadmin_add"));
			subadmin.setSubadminOffice(request.getParameter("office"));
			subadmin.setSubadminPhn(request.getParameter("subadmin_phn"));
			System.out.println("the value we hav are"+subadmin.getSubadminAdd()+subadmin.getSubadminOffice());
			result=subadmindao.modify(subadmin);
			if(result==true)
			{
				System.out.println("success");
				
			}
			dispatcher=request.getRequestDispatcher("crmsearchsubadmin.jsp");	
		}
		dispatcher.forward(request, response);
	}

}
