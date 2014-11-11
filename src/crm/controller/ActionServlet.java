package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.to.SubAdminTO;
import dao.SubAdminDAO;

/**
 * Servlet implementation class ActionServlet
 */

public class ActionServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

    
    public ActionServlet() {
        // TODO Auto-generated constructor stub
    }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 /* String name=null;
  name="<select name='customers' onchange='callAjaxType()'><option value=''>Select a customer:</option><option value='ALFKI'>Alfreds Futterkiste</option><option value='NORTS '>North/South</option><option value='WOLZA'>Wolski Zajazd</option></select>";
  name="<input type='text' name='modify' value = 'Modify' />";
  if(request.getParameter("user").toString().equals("")){
   name="Hello User";
  }
  String a="Wolski";
  String st="<select name='customers' onchange='check()'><option value=''>Select a customer:</option><option value='ALFKI'>Alfreds Futterkiste</option><option value='NORTS '>North/South</option><option value="+a+">"+a+"</option></select>";
  response.setContentType("text/plain");  
  response.setCharacterEncoding("UTF-8"); 
  response.getWriter().write(st); 
 */}

  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
	
	 System.out.println("inside controller");
		SubAdminTO subadmin=new SubAdminTO();
		SubAdminDAO subadmindao=new SubAdminDAO();
		HttpSession session = request.getSession(true);
		String result1=null;
		RequestDispatcher dispatcher=null;
		System.out.println("the value through input"+request.getParameter("delete"));
		System.out.println("the value found is"+request.getParameter("subadmin_id"));
		subadmin.setSubadminId(request.getParameter("subadmin_id"));
		//if(request.getParameter("chkcontrol").equals("1"))
				{
		
		result1=subadmindao.Fetchresult1(subadmin);
		System.out.println("inside controller 1");
		//request.setAttribute("subadmin", subadmin);
		System.out.println("inside controller 2");
		
		//dispatcher=request.getRequestDispatcher("crmShowSubadmin.jsp");	
		System.out.println("inside controller 3");
		
		
		//request.setAttribute("subadmin",subadmin);
		System.out.println("inside controller 4");
		System.out.println("the name is"+subadmin.getSubadminName()+subadmin.getSubadminAdd());
		
				}
		response.setContentType("text/plain");  
		  response.setCharacterEncoding("UTF-8"); 
		  response.getWriter().write(result1); 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //name="<input type='submit' name='modify' value = 'Modify' />";
	  //name = "Hello "+request.getParameter("user");
/*	 String name=null;
	  name="<select name='customers' onchange='callAjaxType()'><option value=''>Select a customer:</option><option value='ALFKI'>Alfreds Futterkiste</option><option value='NORTS '>North/South</option><option value='WOLZA'>Wolski Zajazd</option></select>";
	  name="<input type='text' name='modify' value = 'Modify' />";
	  if(request.getParameter("user").toString().equals("")){
	   name="Hello User";
	  }
	  String a="Wolski";
	  String st="<select name='customers' onchange='check()'><option value=''>Select a ulka:</option><option value='ALFKI'>Alfreds Futterkiste</option><option value='NORTS '>North/South</option><option value="+a+">"+a+"</option></select>";
	  response.setContentType("text/plain");  
	  response.setCharacterEncoding("UTF-8"); 
	  response.getWriter().write(st); 
 */
	
	 
	 
 }

}