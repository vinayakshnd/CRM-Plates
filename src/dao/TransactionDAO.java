package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.bps.util.DbUtil;
import com.bps.util.HibernateUtil;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import crm.to.PlateTO;
import crm.to.TransMaster;
import crm.to.TransSub;

public class TransactionDAO {
	private Connection connection;
	public int addMasterTransaction(TransMaster transaction) 
	{
		
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int transId = 0;
		ArrayList<TransSub> contents = null;
		try
		{
			tx=session.beginTransaction();
			transId = (Integer) session.save(transaction);
			contents = transaction.getContents();
			for(TransSub content : contents) 
			{
				content.setTransaction_id(transId);
				session.save(content);
			}
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return transId;
		
		 
	}
	public TransMaster getOpenTransFor(int client_id){
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		TransMaster transaction = null;
		session.beginTransaction();
		List<TransMaster> listOfTransactions = session.createCriteria(TransMaster.class).add(Restrictions.eq("client_id", client_id)).add(Restrictions.eq("isOpen", 1)).list();
		if(listOfTransactions != null && !listOfTransactions.isEmpty()){			
				transaction = listOfTransactions.get(0);			
				List<TransSub> listOfContents = session.createCriteria(TransSub.class).add(Restrictions.eq("transaction_id", transaction.getTransaction_id())).list();
				
				if(listOfContents != null) {
					ArrayList<TransSub> contents = new ArrayList<TransSub>();
					for(TransSub content : listOfContents) {
						contents.add(content);
						System.out.println(content);
					}
					transaction.setContents(contents);
				}else{
					System.out.println("Empty list found");
				}
		}
		
		
		session.close();
		return transaction;
		
	}
	public String Fetchresult(TransMaster trans) {
		// TODO Auto-generated method stub
		//final String queryStringplate="select Provider_Id,Provider_Name from provider";
		//final String queryStringGetTrans_Id="select * from transaction where client_id=? and open=1";
		//final String queryString1="select a.transaction_id,opening_date,closing_date,advance_amount,subadmin_id,total_amount,client_id,open,content_id,plate_id,rate,quantity,cost,prevalloc,newalloc,submitted,provider_id from transaction a left join sub_transaction b on a.transaction_id=b.transaction_id";
		//final String queryStringprovider2="select * from sub_transaction where transaction_id=?and provider_id=?";
		
		//final String queryString="select newalloc,rate,quantity,cost,submitted from sub_transaction where transaction_id=? and provider_id=? and plate_id=?";
		PreparedStatement statement=null;
		String provider1=null;
		String provider2=null;
		String plate1=null;
		String plate2=null;
		ResultSet result=null;
		int j=0;
		int new_t,prev_t,sub_t,total_t;
		StringBuffer str1=new StringBuffer();
		PlateDAO platedao=new PlateDAO();
		ArrayList<PlateTO> plate=platedao.getAllPlates();
		str1.append("<table><tr>");
		str1.append("<td>Date from : </td>");
		str1.append("<td><input type='date' name='dateFrom' value="+System.currentTimeMillis()+">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		  str1.append("<td>Date to :</td>");
		   str1.append("</tr></table><table>");
		try {
			connection =DbUtil.getConnection();
			HashMap<Integer, String>provider=getUniqueProvidersFromTrans(trans);
			Set<Integer>unique_prov=provider.keySet();
			for (Integer i : unique_prov) 
			{
				System.out.println("piyush"+i+"+hey");
				new_t=0;
				prev_t=0;
				sub_t=0;
				total_t=0;
				str1.append("<tr><td>"+i+"</td><td>");
				str1.append("<input type='hidden' value="+i+" name='provider_id'>");
				str1.append("</td></tr><tr><td>");
				str1.append("<div id="+i+">");
				str1.append("<table border='1' cellspacing='0'>");
			    str1.append("<tr>");
			    str1.append("<th>Size</th>");
			    str1.append("<th>Previously alloted</th>");
			    str1.append("<th>New</th>");
			    str1.append("<th>Returned</th>");
			    str1.append("<th style='color:red'>Total</th>");
			    str1.append("<th>Rate</th>");
			    str1.append("</tr>");
				for(PlateTO plateto:plate)
				{
					TransSub sub;
					if((sub=getContentFor(i,plateto.getPlate_Id(),trans))!=null)
					{
						str1.append("<tr><td><input type='hidden' value="+plateto.getPlate_Id()+" name='plate_id'>");
					    str1.append(plateto.getSize());
					    str1.append("</td><td>");
					    str1.append("<input type='text' name='previouslyAlloted' value="+sub.getNewalloc()+" width='10' readonly='readonly'>");
					    str1.append("</td><td>");
					    str1.append("<input type='text' name='new' value='0' width='10' onblur='updatetotal()'>");
					    str1.append("</td><td>");
					    str1.append("<input type='text' name='submitted' value='0' width='10' onblur='updatetotal()'>");
					    str1.append("</td><td>");
					    str1.append("<input type='text' name='total' value="+(sub.getNewalloc()+sub.getPrevalloc()-sub.getSubmitted())+" width='10' style='color:red'>");
					    str1.append("</td><td>");
					    str1.append("<input type='text' name='rate' value="+sub.getRate()+" width='10' onblur='updatetotal()'>");
					    str1.append("</td></tr>");
					    new_t=new_t+sub.getNewalloc();
						prev_t=prev_t+sub.getPrevalloc();
						sub_t=sub_t+sub.getSubmitted();
						total_t=total_t+(sub.getNewalloc()+sub.getPrevalloc()-sub.getSubmitted());
					}
				}
				str1.append("<tr><td>");
				str1.append("total");
				str1.append("<td><input type='text' name='previouslyAlloted_total' value="+prev_t+" width='10' style='color:red'></td>");
				str1.append("<td><input type='text' name='new_total' value="+new_t+" width='10' style='color:red'></td>");
				str1.append("<td><input type='text' name='submitted_total' value="+sub_t+" width='10' style='color:red'></td>");
				str1.append("<td><input type='text' name='total_total' value="+total_t+" width='10' style='color:red'></td>");
				str1.append("</tr></table>");
				str1.append("</div> </td></tr>");
			}
			str1.append("<tr><td><table><tr>");
			str1.append("<td><table cellspacing='0' ><tr><td>");
			str1.append("Advance :");
			str1.append("</td><td>");
			str1.append("<input type='text' name='advance' value='500'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			str1.append("</td></tr><tr><td>");
			str1.append("Total :");
			str1.append("</td><td>");
			str1.append("<input type='text' name='totalAmount' value='1000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			str1.append("</td></tr></table></td><td>");
			str1.append("</td></tr></table>");
			str1.append("<input type='submit' value='Create Order'>");
			str1.append("<input type='reset' value='Cancel'>");
			str1.append("</td></tr></table>");
			return str1.toString();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * Returns a hashmap , inturn returning unique set of providers
	 * from given transaction
	 * @param transaction
	 * @return
	 */
	public HashMap<Integer, String> getUniqueProvidersFromTrans(TransMaster transaction) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		if(transaction == null) 
			return null;
		ArrayList<TransSub> contents = transaction.getContents();
		
		for(TransSub content : contents){
			map.put(content.getProvider_id(),"1");
		}
		return map;
	}
	/**
	 * Searches for the subtransaction that has given provider_id and plate_id
	 * @param provider_id
	 * @param plate_id
	 * @param transaction
	 * @return
	 */
	public TransSub getContentFor(int provider_id,int plate_id,TransMaster transaction){
		ArrayList<TransSub> transContents = transaction.getContents();
		
		for(TransSub content : transContents){
			if(content.getProvider_id() == provider_id){
				if(content.getPlate_id() == plate_id){
					return content;
				}
			}
		}
		return null;
		
	}

}