package crm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.to.PlateTO;
import dao.PlateDAO;

/**
 * Servlet implementation class AddTableTransAjax
 */
public class AddTableTransAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTableTransAjax() {
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
		PlateDAO platedao=new PlateDAO();
		ArrayList<PlateTO> listOfPlates = new ArrayList<PlateTO>();
		listOfPlates=platedao.getAllPlates();
		StringBuffer str1=new StringBuffer();
		str1.append("<table border='1' cellspacing='0'>");
	    str1.append("<tr>");
	    str1.append("<th>Size</th>");
	    str1.append("<th>Previously alloted</th>");
	    str1.append("<th>New</th>");
	    str1.append("<th>Returned</th>");
	    str1.append("<th style='color:red'>Total</th>");
	    str1.append("<th>Rate</th>");
	    str1.append("</tr>");
		for (PlateTO plate : listOfPlates) {
			str1.append("<td><input type='hidden' value="+plate.getPlate_Id()+" name='plate_id'>");
		    str1.append(plate.getSize());
		    str1.append("</td><td>");
		    str1.append("<input type='text' name='previouslyAlloted' value='0' width='10' readonly='readonly'>");
		    str1.append("</td><td>");
		    str1.append("<input type='text' name='new' value='0' width='10' onblur='updatetotal()'>");
		    str1.append("</td><td>");
		    str1.append("<input type='text' name='submitted' value='0' width='10' onblur='updatetotal()'>");
		    str1.append("</td><td>");
		    str1.append("<input type='text' name='total' value='0' width='10' style='color:red'>");
		    str1.append("</td><td>");
		    str1.append("<input type='text' name='rate' value="+plate.getRate_Per_Plate()+" width='10' onblur='updatetotal()'>");
		    str1.append("</td></tr>");
		   
		    	
		}
		str1.append("<tr><td>");
		str1.append("total");
		str1.append("<td><input type='text' name='previouslyAlloted_total' value='0' width='10' style='color:red'></td>");
		str1.append("<td><input type='text' name='new_total' value='0' width='10' style='color:red'></td>");
		str1.append("<td><input type='text' name='submitted_total' value='0' width='10' style='color:red'></td>");
		str1.append("<td><input type='text' name='total_total' value='0' width='10' style='color:red'></td>");
		str1.append("</tr></table>");
		response.setContentType("text/plain");  
		  response.setCharacterEncoding("UTF-8"); 
		  response.getWriter().write(str1.toString()); 
					
	}
}


