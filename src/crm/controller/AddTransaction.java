package crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.to.PlateTO;
import crm.to.TransMaster;
import crm.to.TransSub;
import dao.TransactionDAO;

/**
 * Servlet implementation class AddTransaction
 */
public class AddTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTransaction() {
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
		int result;
		
		transactionMaster.setTransaction_id(01);
		transactionMaster.setDate(request.getParameter("dateFrom"));
		//transactionMaster.setClient_id(Integer.parseInt(request.getParameter("client_id")));
		transactionMaster.setClient_id(Integer.parseInt(request.getParameter("client_id")));
		transactionMaster.setSubadmin_id(12);		//Hardcoded needs to be changed
		transactionMaster.setTotal_amount(Float.parseFloat(request.getParameter("totalAmount")));
		transactionMaster.setAdvance(Float.parseFloat(request.getParameter("advance")));
		
		transactionMaster.setRemaining_amount(transactionMaster.getTotal_amount()-transactionMaster.getAdvance());
		transactionMaster.setIsOpen(1);
		transactionMaster.setClosingDate(request.getParameter("dateTo"));
		
		
		
		String provider_id[]=request.getParameterValues("provider_id");
		String plate_id[]=request.getParameterValues("plate_id");
		String prevalloc[]=request.getParameterValues("previouslyAlloted");
		String new1[]=request.getParameterValues("new");
		String rate[]=request.getParameterValues("rate");
		String submitted[]=request.getParameterValues("submitted");
		int i=plate_id.length/provider_id.length;
		int k=0;
		System.out.println(provider_id.length+"+"+plate_id.length+"+"+prevalloc.length);
		for (String provider : provider_id)
		{
			for(int j=0;j<i;j++)		
			{	 
				System.out.println("Adding new entry");
				trans = new TransSub();
				
				System.out.println("piyush"+plate_id[k]);
				//trans.setQuantity(Integer.parseInt(request.getParameter("noOfPlates".concat(Integer.toString(j*10+i)))));
				//hardcoded needs to be changed
				trans.setProvider_id(Integer.parseInt(provider));
				trans.setPrevalloc(Integer.parseInt(prevalloc[k])); 
				trans.setNewalloc(Integer.parseInt(new1[k]));
				trans.setRate(Float.parseFloat(rate[k]));
				trans.setSubmitted(Integer.parseInt(submitted[k]));
				trans.setQuantity(trans.getNewalloc()+trans.getPrevalloc()-trans.getSubmitted());
				
				trans.setPlate_id(Integer.parseInt(plate_id[k]));
				//hardcoded
				
				//trans.setPlate_id();
				trans.setCost(trans.getRate()*trans.getQuantity());
				k++;
				if(transactionMaster.addContents(trans)) 
				{
					System.out.println("Added" + trans.toString() + "Successfully");
				}
				else
				{
					System.out.println("Addition of " + trans.toString() + "failed");
				}
			
			}
		}
		result=transactionDAO.addMasterTransaction(transactionMaster);
		transactionMaster = transactionDAO.getOpenTransFor(20);
		System.out.println("Fetched form db " + transactionMaster);
	}
}
