package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.bps.util.DbUtil;
import com.bps.util.HibernateUtil;

import crm.to.ClientTO;
import crm.to.TransSub;

public class ClientDAO {
	private Connection connection;
	public String Fetchresult(ClientTO client) {
		// TODO Auto-generated method stub
		final String queryString="select * from client where client_id=?";
		ResultSet result=null;
		StringBuffer str1=new StringBuffer();
		PreparedStatement statement=null;
		System.out.println("inside DAO");
		try
			{
			connection =DbUtil.getConnection();
			statement=connection.prepareStatement(queryString);
			statement.setInt(1,client.getClient_id());
			result=statement.executeQuery();
			System.out.println("inside chek query");
			if(result.next())
			{
					System.out.println("hello");
					client.setClient_name(result.getString(2));
					client.setClient_add(result.getString(3));
					client.setClient_phn(result.getString(4));
					client.setClient_site_add(result.getString(5));
					client.setGuaranter_name(result.getString(6));
					client.setGuaranter_phn(result.getString(7));
			}	
			
			str1.append("<form action='ModifyClient' method='post' name='crmmodifyclient' onsubmit='return validate1()'>");
			str1.append("<table><tr><td>Client Name :</td><td>");
			str1.append("<input type='hidden' value="+client.getClient_id()+" name='client_id'>");
			str1.append("<input type='text' value="+client.getClient_name()+" name='client_name' onkeypress='return isChar(event)'>"+"</td><td><span id='errorSpan1' style='color:red'></span>");
			str1.append("</td></tr><tr><td>Client Address</td><td>");
			str1.append("<textarea name='client_add' rows='2' cols='50'>"+client.getClient_add()+"</textarea>"+"</td><td><span id='errorSpan2' style='color:red'></span>");
			str1.append("</td></tr><tr><td>Client Phone Number</td><td>");
			str1.append("<input type='text' value="+client.getClient_phn()+" name='client_phn' onchange='isphone1()' onkeypress='return isNumber1(event)'><td><span id='errorSpan3' style='color:red'></span>");
			str1.append("</td></tr><tr><td>Client Site Address</td><td>");  
			str1.append("<textarea name='client_site_add' rows='2' cols='50'>"+client.getClient_site_add()+"</textarea>"+"</td><td><span id='errorSpan4' style='color:red'></span>");
			str1.append("</td></tr><tr><td>Guaranter Name</td><td>");  
			str1.append("<input type='text' value="+client.getGuaranter_name()+" name='guaranter_name'><td><span id='errorSpan5' style='color:red'></span>");
			str1.append("</td></tr><tr><td>Guaranter Phone</td><td>");  
			str1.append("<input type='text' value="+client.getGuaranter_phn()+" name='guaranter_phn' onchange='isphone2()' onkeypress='return isNumber2(event)'><td><span id='errorSpan6' style='color:red'></span>");	
			str1.append("</td></tr><tr><td>");
			str1.append("<input type='submit' value='submit' name='submit'>");
			str1.append("</td><td>");
			str1.append("<input class='ui-btn ui-icon-delete ui-btn-icon-left' type='submit' value='delete' name='submit'>");
			str1.append("</td></tr></table></form>");
					
					//statement.setString(1,subadmin.getSubadminOffice());
			System.out.println("inside DAO fetching result");
			return str1.toString();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		finally
		{
	//	 return subadmin;
		}
	
		return str1.toString();
	}
	public boolean modify(ClientTO client) {
		// TODO Auto-generated method stub
		int flag=0;
		String message="Record Updated Successfully";
		
		PreparedStatement statement=null;
		//String Office_id;
		System.out.println("inside DAO");
		try
			{
				
			connection =DbUtil.getConnection();
			//statement=connection.prepareStatement("select Office_Id from agency_info where Office_Nm");	
			statement=connection.prepareStatement("Update client set client_name=?,client_address=?,client_phn=?,client_site_add=?,guaranter_name=?,guaranter_phn=? where client_id=?");
				System.out.println("inside DAO");
				statement.setString(1,client.getClient_name());
				System.out.println("inside DAO");
				statement.setString(2,client.getClient_add());
				
				statement.setString(3,client.getClient_phn());
				statement.setString(4,client.getClient_site_add());
				
				statement.setString(5,client.getGuaranter_name());
				statement.setString(6,client.getGuaranter_phn());
				
				
				
				
				statement.setInt(7,client.getClient_id());
				
				if(statement.executeUpdate()==0)
				{
					return false;
				}
				else
					return true;
			}
		catch(SQLException io)
		{
		
		}
		catch(ClassNotFoundException io)
		{
		
		}
		catch(IOException io1)
		{
		
		}
		return true;

	}
	public Integer addClient(ClientTO client) {
		
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int clientId = 0;
		ArrayList<TransSub> contents = null;
		try
		{
			tx=session.beginTransaction();
			clientId = (Integer) session.save(client);
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
		return clientId;
		// TODO Auto-generated method stub
//		String querystring="insert into client values(?,?,?,?,?,?,?)";
//		PreparedStatement statement=null;
//		int results;
//		try{
//			connection =DbUtil.getConnection();
//			statement = connection.prepareStatement(querystring); 
//			statement.setInt(1,client.getClient_id());
//			statement.setString(2,client.getClient_name());
//			statement.setString(3,client.getClient_add());
//			statement.setString(4,client.getClient_phn());
//			statement.setString(5,client.getClient_site_add());
//			statement.setString(6,client.getGuaranter_name());
//			statement.setString(7,client.getGuaranter_phn());
//			
//			results = statement.executeUpdate();
//			if(results==0)
//			{
//				return false;
//		    }
//			else
//			{
//				return true;
//			}
//		}
//		catch(SQLException io)
//		{
//			
//		}
//		finally
//		{
//		return false;
//
//		}
//
//	}
		
	}
}
