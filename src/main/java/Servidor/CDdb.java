package Servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Servidor.CD;
public class CDdb {
	
	private DataSource ds;
	
		public CDdb()
		{
			try {
					Context ctx = new InitialContext();
					ds = (DataSource)ctx.lookup("java:comp/env/jdbc/cddb");
			}
			catch (NamingException e) 
			{
					e.printStackTrace();
			}
		}
		public List<CD> getCDlist() throws SQLException{
			 
			  //get database connection
			  Connection con = ds.getConnection();
			  //...
			  Statement stmt = con.createStatement();
			  String query = "select * from CD";
			  ResultSet rs = stmt.executeQuery(query);//lista CD bbdd
			  List ll = new LinkedList();
			  //per cada una de las lines de la bbdd  faig un CD
			  while (rs.next())
			  {
				  String str = rs.getString("name"); //nom columna podem posael numero de la columna
				  String str1 = rs.getString("grup");
				  String str2 = rs.getString("pais");
				  float dou = rs.getFloat("price");
				  CD cd = new CD();
				  cd.setAlbum(str);// lo mateix per tots els atributs
				  cd.setArtist(str1);
				  cd.setCountry(str2);
				  cd.setPrice(dou);
				  
				  ll.add(cd);//llista CD bbdd
			  }
			  return ll;//returnem llista
			  }
			  

}
