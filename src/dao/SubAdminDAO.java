package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.bps.util.DbUtil;
import com.bps.util.HibernateUtil;

import crm.to.SubAdminTO;
import crm.to.TransMaster;
import crm.to.TransSub;
import crm.to.UserTO;
public class SubAdminDAO {
	private Connection connection;
	
	@SuppressWarnings("finally")
	public SubAdminTO Fetchresult(SubAdminTO subadmin) {
		// TODO Auto-generated method stub
		
		final String queryString="select * from userinfo where User=?";
		ResultSet result=null;
		PreparedStatement statement=null;
		System.out.println("inside DAO");
		try
			{
				connection =DbUtil.getConnection();
				statement=connection.prepareStatement(queryString);
				statement.setString(1,subadmin.getSubadminId());
				result=statement.executeQuery();
				System.out.println("inside chek query");
				if(result.next())
				{
					System.out.println("inside DAO fetching result");
					subadmin.setSubadminId(result.getString(1));
					subadmin.setSubadminName(result.getString(2));
					subadmin.setSubadminAdd(result.getString(3));
					subadmin.setSubadminPhn(result.getString(4));
					subadmin.setSubadminOffice(result.getString(5));
				}
				return subadmin;
			}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		finally
		{
		 return subadmin;
		}
	}

	public boolean modify(SubAdminTO subadmin) {
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
			statement=connection.prepareStatement("Update userinfo set User_name=?,User_Add=?,User_phn=?,Office_Id=? where User=?");
				System.out.println("inside DAO");
				statement.setString(1,subadmin.getSubadminName());
				System.out.println("inside DAO");
				statement.setString(2,subadmin.getSubadminAdd());
				
				statement.setString(3,subadmin.getSubadminPhn());
				
				statement.setString(4,subadmin.getSubadminOffice());
				statement.setString(5, subadmin.getSubadminId());
				
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

	public String Fetchresult1(SubAdminTO subadmin) {
		// TODO Auto-generated method stub
		final String queryString="select User,User_Name,User_Add,User_Phn,a.Office_Id,b.Office_Name from userinfo a left join agency_info b on a.Office_Id=b.Office_Id where User=?";
		//final String queryString="select * from userinfo where User=?";
		final String queryString1="select * from agency_info";
		//final String queryString2="select ";
		ResultSet result=null;
		
				StringBuffer str1=new StringBuffer();
				String temp1=null;
				String temp2=null;
		PreparedStatement statement=null;
		System.out.println("inside DAO");
		try
			{
				connection =DbUtil.getConnection();
				statement=connection.prepareStatement(queryString);
				statement.setString(1,subadmin.getSubadminId());
				result=statement.executeQuery();
				System.out.println("inside chek query");
				if(result.next())
				{
					System.out.println("inside DAO fetching result");
					subadmin.setSubadminId(result.getString(1));
					System.out.println("inside DAO fetching result2");
					subadmin.setSubadminName(result.getString(2));
					System.out.println("inside DAO fetching result3");
					subadmin.setSubadminAdd(result.getString(3));
					System.out.println("inside DAO fetching result4");
					subadmin.setSubadminPhn(result.getString(4));
					System.out.println("inside DAO fetching result5");
					subadmin.setSubadminOffice(result.getString(5));
					System.out.println("inside DAO fetching result6");
					temp1=result.getString(6);
					System.out.println("inside DAO fetching result7");
				}	
				
		
				str1.append("<form action='ModifySubadmin' method='post' name='crmmodifysubadmin' onsubmit='return validate1()'>");
						str1.append("<table> <tr><td>Name :</td><td>");
					str1.append("<input type='hidden' value="+subadmin.getSubadminId()+" name='subadmin_id'>");
					str1.append("<input type='text' value="+subadmin.getSubadminName()+" name='subadmin_name'><td><span id='errorSpan1' style='color:red'></span></td>");
					str1.append("</td><tr><td>Address</td>");
					str1.append("<td><textarea name='subadmin_add' rows='2' cols='50'>"+subadmin.getSubadminAdd()+"</textarea>"+"</td><td><span id='errorSpan2' style='color:red'></span></td>");
					str1.append("</td></tr><tr><td>Phone Number</td>");
					str1.append("<td><input type='text' value="+subadmin.getSubadminPhn()+" name='subadmin_phn' onchange='isphone()' onkeypress='return isNumber3(event)'><td><span id='errorSpan3' style='color:red'></span></td>");
					str1.append("</td></tr><tr><td>Select Office</td><td><select name='office'>");  
					str1.append("<option value="+subadmin.getSubadminOffice()+">"+temp1);
					str1.append("</option>"); 
				
					
					statement=connection.prepareStatement(queryString1);
					//statement.setString(1,subadmin.getSubadminOffice());
					result=statement.executeQuery();
					System.out.println("inside chek query");
					while(result.next())
					{
						System.out.println("inside ofc");
						temp1=result.getString(1);
					temp2=result.getString(2);
					str1.append("<option value="+temp1+">"+temp2);
					str1.append("</option>"); 
					}
					
					
					str1.append("</select></td></tr><tr><td>");
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

	/**
	 * Adds the subadmin along with the user in user table
	 * 
	 * @param subadmin
	 * @param user
	 * @return 1 - If the user with same username does not already exists and 
	 * 			the entry for the subadmin and user is successfully added.
	 * 		   2 - If the user with same username already exists
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int addresult(SubAdminTO subadmin, UserTO user) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int subadminId = 0;
		int result = 0;
		try{
		
			tx=session.beginTransaction();
		
			List<UserTO> listOfusers = session.createCriteria(UserTO.class).add(Restrictions.eq("User", subadmin.getSubadminName())).list();
			if(listOfusers != null && !listOfusers.isEmpty()){			
				//User with the same name already exists	
				result = 2;
				
			}else{
				//There is no already existing user with same name so add it
				subadminId = (Integer) session.save(subadmin);
				session.save(user);
				result = 1;
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
		return result;
		
//		String querystring1="select * from user where User=?";
//		String querystring="insert into userinfo values(?,?,?,?,?,0)";
//		String querystring2="insert into user values(?,?,2)";
//		PreparedStatement statement=null;
//		PreparedStatement statement2=null;
//		ResultSet results;
//		int result;
//		try{
//			connection =DbUtil.getConnection();
//			statement = connection.prepareStatement(querystring1); 
//			statement.setString(1,subadmin.getSubadminId());
//			results=statement.executeQuery();
//			
//			if(results.next())
//			{
//				result=1;
//			}
//			else
//			{
//				statement.close();
//				statement = connection.prepareStatement(querystring);
//				statement.setString(1,subadmin.getSubadminId());
//				statement.setString(2,subadmin.getSubadminName());
//				statement.setString(3, subadmin.getSubadminAdd());
//				statement.setString(4, subadmin.getSubadminPhn());
//				statement.setString(5, subadmin.getSubadminOffice());
//				result = statement.executeUpdate();
//				if(result==0)
//				{
//					result=0;
//				}
//				else
//				{
//					statement2=connection.prepareStatement(querystring2);
//					statement2.setString(1,subadmin.getSubadminId());
//					statement2.setString(2, subadmin.getPassword());
//					result=statement2.executeUpdate();
//					result=2;
//				}
//			}
//			return result;
//		}
//		catch(IOException io)
//		{
//			return 0; 		
//		}
//			
//		
//			
//		
	}
}


