package crm.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import crm.to.TransMaster;
import crm.to.TransSub;
import dao.TransactionDAO;

/**
 * Servlet implementation class OrderController
 */
public class AddTrans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrans() {
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
		
		TransMaster transactionMaster = new TransMaster();
		TransactionDAO transactionDAO=new TransactionDAO();
		TransSub trans=new TransSub();
		
		int transId;
		String[] provider_id=new String [10];
		
		provider_id[1]="pr1";
		provider_id[2]="pr2";
		transactionMaster.setDate(request.getParameter("dateFrom"));
		transactionMaster.setClient_id(Integer.parseInt(request.getParameter("client_id")));
		//hardcoded 
		transactionMaster.setSubadmin_id(10);
		transactionMaster.setTotal_amount(Float.parseFloat(request.getParameter("totalAmount")));
		transactionMaster.setAdvance(Float.parseFloat(request.getParameter("advance")));
		transactionMaster.setRemaining_amount(transactionMaster.getTotal_amount()-transactionMaster.getAdvance());
		transactionMaster.setIsOpen(1);
		transactionMaster.setClosingDate(request.getParameter("dateTo"));
		System.out.println("client id = " + transactionMaster.getClient_id());
		
		 int numOfPlates,numOfProviders;
		 numOfPlates=Integer.parseInt(request.getParameter("noofplates"));
		 numOfProviders=Integer.parseInt(request.getParameter("nofproviders"));
		
		 System.out.println("vinayak"+numOfPlates+":"+numOfProviders);
		
		  
		 System.out.println("the plate value"+request.getParameter("amount11"));
		 for(int j=1;j<=numOfProviders;j++)
		 {
			 System.out.println("the id in controller is="+j+"id="+provider_id[j]);
			 System.out.println("" + request.getParameter(provider_id[j]));
			 if(request.getParameter(provider_id[j])!=null)
			 {
			  System.out.println("inside loop");
			  
			  for(int i=1;i<=numOfPlates;i++)		
			  { 
				  System.out.println("Adding new entry");
				trans = new TransSub();
				//trans.setContent_id(Long.toString(((System.currentTimeMillis()))));
				System.out.println("piyush"+request.getParameter("amount".concat(Integer.toString(j*10+i))));
				//trans.setQuantity(Integer.parseInt(request.getParameter("noOfPlates".concat(Integer.toString(j*10+i)))));
				
				
				trans.setProvider_id(Integer.parseInt(request.getParameter(provider_id[j])));
				trans.setPrevalloc(Integer.parseInt(request.getParameter("previouslyAlloted".concat(Integer.toString(j*10+i))))); 
				trans.setNewalloc(Integer.parseInt(request.getParameter("new".concat(Integer.toString(j*10+i)))));
				trans.setRate(Float.parseFloat(request.getParameter("rate".concat(Integer.toString(j*10+i)))));
				trans.setSubmitted(Integer.parseInt(request.getParameter("submitted".concat(Integer.toString(j*10+i)))));
				trans.setQuantity(trans.getNewalloc()+trans.getPrevalloc()+trans.getSubmitted());
				trans.setPlate_id(Integer.parseInt(request.getParameter("plate".concat(Integer.toString(j*10+i)))));
				trans.setCost(trans.getRate()*trans.getQuantity());
				
				/*
				 * Insert entry in master transaction
				 */
				if(transactionMaster.addContents(trans)) {
				System.out.println("Added" + trans.toString() + "Successfully");
				}
				else{
					System.out.println("Addition of " + trans.toString() + "failed");
				}
			  }
			  //
			 }
		 }
		 transId=transactionDAO.addMasterTransaction(transactionMaster);
	}
}
