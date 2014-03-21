package Servidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Servidor.CDdb;
public class CDi {
	
	private DataSource ds1;
	private PreparedStatement preparedStatement ;
	double price= 0.0;
	int numCD=0;
	public CDi()
	{
		try {
				Context ctx = new InitialContext();
				ds1 = (DataSource)ctx.lookup("java:comp/env/jdbc/cddb");//nombre igual  src>main>webapp en el context.xml
		}
		catch (NamingException e) 
		{
				e.printStackTrace();
		}
	}
	public void InsertQuantity (int num){//num CD en el Checkout le pasaremos el int
		
		numCD = num + numCD;
	}
	public void InsertAmount (String precio)//Amount es el total
	{
		price  = Double.parseDouble(precio);
	}
	
	public void compra() throws SQLException
	{
		
		 //get database connection
		  Connection con = ds1.getConnection();
		  //...
		  preparedStatement = con.prepareStatement ("insert into compras (numcds, total) values ( ? , ?)");
		  preparedStatement.setInt(1, numCD);
		  preparedStatement.setDouble(2, price);
		  preparedStatement.executeUpdate();
		  
		 	}
	

}
