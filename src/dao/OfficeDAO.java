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

import crm.to.OfficeTO;
import crm.to.TransSub;

public class OfficeDAO {
	private Connection connection;

	public int addresult(OfficeTO office) {
		
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int officeId = 0;
		ArrayList<TransSub> contents = null;
		try
		{
			tx=session.beginTransaction();
			officeId = (Integer) session.save(office);
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
		return officeId;
		
		// TODO Auto-generated method stub
//		String querystring="insert into agency_info values(?,?,?,?)";
//		PreparedStatement statement=null;
//		int results;
//		try{
//			connection =DbUtil.getConnection();
//			statement = connection.prepareStatement(querystring); 
//			statement.setInt(1,office.getOffice_Id());
//			statement.setString(2,office.getOffice_Name());
//			statement.setString(3,office.getOffice_Add());
//			statement.setString(4,office.getOffice_Phn());
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
		
	}

	public String Fetchresult(OfficeTO office1) {
		// TODO Auto-generated method stub
		final String queryString="select * from agency_info where Office_Id=?";
		//final String queryString="select * from userinfo where User=?";
		//final String queryString1="select * from agency_info";
		//final String queryString2="select ";
		ResultSet result=null;
		
				StringBuffer str1=new StringBuffer();
			//	String temp1=null;
			//	String temp2=null;
		PreparedStatement statement=null;
		System.out.println("inside DAO");
		try
			{
				connection =DbUtil.getConnection();
				statement=connection.prepareStatement(queryString);
				statement.setInt(1,office1.getOffice_Id());
				result=statement.executeQuery();
				System.out.println("inside chek query");
				if(result.next())
				{
					System.out.println("inside DAO fetching result");
					office1.setOffice_Id(result.getInt(1));
					System.out.println("inside DAO fetching result2");
					office1.setOffice_Name(result.getString(2));
					System.out.println("inside DAO fetching result3");
					office1.setOffice_Add(result.getString(3));
					System.out.println("inside DAO fetching result4");
					office1.setOffice_Phn(result.getString(4));
					
				}	
				
		
				str1.append("<form action='ModifyOffice' method='post' name='crmmodifyoffice' onsubmit='return validate1()'>");
						str1.append("<table> <tr><td>Name :</td><td>");
					str1.append("<input type='hidden' value="+office1.getOffice_Id()+" name='office_id'>");
					str1.append("<input type='text' value="+office1.getOffice_Name()+" name='office_name'></td><td><span id='errorSpan1' style='color:red'></span></td>");
					str1.append("</td><tr><td>Address</td>");
					str1.append("<td><textarea name='office_add' rows='2' cols='50'>"+office1.getOffice_Add()+"</textarea>"+"</td><td><span id='errorSpan2' style='color:red'></span></td>");
					str1.append("</td></tr><tr><td>Phone Number</td>");
					str1.append("<td><input type='text' value="+office1.getOffice_Phn()+" name='office_phn' onchange='isphone()' onkeypress='return isNumber3(event)'></td><td><span id='errorSpan3' style='color:red'></span></td>");
					str1.append("</tr><tr><td>");
					str1.append("<input type='submit' value='submit' name='submit'>");
					str1.append("</td><td><input class='ui-btn ui-icon-delete ui-btn-icon-left' type='submit' value='delete' name='submit'>");
					str1.append("</td><td><input type='hidden' value='2' name='chkcontrol'>");
					str1.append("</td></tr></table></form>");
					
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

	public boolean modify(OfficeTO office) {
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
			statement=connection.prepareStatement("Update agency_info set Office_Name=?,Office_Add=?,Office_Phn=? where Office_Id=?");
				System.out.println("inside DAO");
				statement.setString(1,office.getOffice_Name());
				System.out.println("inside DAO");
				
				
				statement.setString(2,office.getOffice_Add());
				
				statement.setString(3,office.getOffice_Phn());
				statement.setInt(4,office.getOffice_Id());
				
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

	}

