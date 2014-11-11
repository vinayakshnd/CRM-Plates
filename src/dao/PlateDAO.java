package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.bps.util.DbUtil;
import com.bps.util.HibernateUtil;

import crm.to.PlateTO;
import crm.to.TransMaster;
import crm.to.TransSub;

public class PlateDAO {
	private Connection connection;
public  ArrayList<PlateTO> getAllPlates(){
		
		ArrayList<PlateTO> listOfPlates = new ArrayList<PlateTO>();
		PreparedStatement selectAllPlates = null;
		PlateTO plate;
		try {
			connection = DbUtil.getConnection();
		
		selectAllPlates = connection.prepareStatement("select * from plate_info");
		ResultSet result1 = selectAllPlates.executeQuery();
		
		while(result1.next())
		{	
			plate = new PlateTO();
			plate.setPlate_Id(result1.getInt(1));
			plate.setSize(result1.getString(2));
			plate.setTotal_Plate(result1.getInt(3));
			plate.setAvailable_Plate(result1.getInt(4));
			plate.setRate_Per_Plate(result1.getFloat(5));
			listOfPlates.add(plate);
			
		}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
		
				try {
					selectAllPlates.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return listOfPlates;	
	}
	
	public String Fetchresult(PlateTO plate) {
		// TODO Auto-generated method stub
		final String queryString="select * from plate_info where Plate_Id=?";
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
				statement.setInt(1,plate.getPlate_Id());
				result=statement.executeQuery();
				System.out.println("inside chek query");
				if(result.next())
				{
					System.out.println("inside DAO fetching result2++++");
					plate.setSize(result.getString(2));
					System.out.println("inside DAO fetching result3");
					plate.setTotal_Plate(result.getInt(3));
					System.out.println("inside DAO fetching result4");
					plate.setAvailable_Plate(result.getInt(4));
					plate.setRate_Per_Plate(result.getFloat(5));
				}	
				
		
					str1.append("<form action='ModifyPlate' method='post' name='crmmodifyplate' onsubmit='return validate1()'>");
					str1.append("<table> <tr><td>Size :</td><td>");
					str1.append("<input type='hidden' value="+plate.getPlate_Id()+" name='plate_id'>");
					str1.append("<input type='text' value="+plate.getSize()+" name='plate_size'></td><td><span id='errorSpan1' style='color:red'></span></td>");
					str1.append("</tr><tr><td>Total Plates</td>");
					str1.append("<td><input type='text' value="+plate.getTotal_Plate()+" name='plate_total' onkeypress='return isNumber1(event)'></td><td><span id='errorSpan2' style='color:red'></span>");
					str1.append("</td></tr><tr><td>Available Plate</td>");
					str1.append("<td><input type='text' value="+plate.getAvailable_Plate()+" name='plate_available' onkeypress='return isNumber2(event)'></td><td><span id='errorSpan3' style='color:red'></span></td>");
					str1.append("</tr><tr><td>Rate Per Plate</td><td>");
					str1.append("<input type='text' value="+plate.getRate_Per_Plate()+" name='plate_rate'></td><td><span id='errorSpan4' style='color:red'></span></td>");
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
	/**
	 * Returns a hashmap , inturn returning unique set of providers
	 * from given transaction
	 * @param transaction
	 * @return
	 */
	public HashMap getUniqueProvidersFromTrans(TransMaster transaction) {
		HashMap map = new HashMap<String, String>();
		if(transaction == null) 
			return null;
		ArrayList<TransSub> contents = transaction.getContents();
		
		for(TransSub content : contents){
			map.put(content.getProvider_id(),1);
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
	public boolean modify(PlateTO plate) {
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
			statement=connection.prepareStatement("Update plate_info set Size=?,Total=?,Available=?,RatePerPlate=? where Plate_Id=?");
				System.out.println("inside DAO");
				statement.setString(1,plate.getSize());
				System.out.println("inside DAO");
				statement.setInt(2,plate.getTotal_Plate());
				
				statement.setInt(3,plate.getAvailable_Plate());
				
				statement.setFloat(4,plate.getRate_Per_Plate());
				statement.setInt(5, plate.getPlate_Id());
				
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
	public int addresult(PlateTO plate) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int plateId = 0;
		ArrayList<TransSub> contents = null;
		try
		{
			tx=session.beginTransaction();
			plateId = (Integer) session.save(plate);
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
		return plateId;
	}
}
		
//		String querystring="insert into plate_info values(?,?,?,?,?)";
//		PreparedStatement statement=null;
//		int results;
//		try{
//			connection =DbUtil.getConnection();
//			statement = connection.prepareStatement(querystring); 
//			statement.setInt(1,plate.getPlate_Id());
//			statement.setString(2,plate.getSize());
//			statement.setInt(3,plate.getTotal_Plate());
//			statement.setInt(4,plate.getAvailable_Plate());
//			statement.setFloat(5, plate.getRate_Per_Plate());
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
//	}


