package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bps.util.DbUtil;

import crm.to.UserTO;

public class UserDAO {
	private Connection connection;

	public boolean uservalidate(UserTO userto) {
		// TODO Auto-generated method stub
ResultSet result=null;
		
		PreparedStatement statement=null;
		try {
			connection =DbUtil.getConnection();
		
			statement=connection.prepareStatement("select User,Password from user where User=? and Password=?");
			statement.setString(1, userto.getUsername());
			statement.setString(2, userto.getPassword());
			result = statement.executeQuery();
			if(result.next())
			{
				System.out.println("success");
				return true;
			}
			else
				return false;
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
		return false;
	}

}
