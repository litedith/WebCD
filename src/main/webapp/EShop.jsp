<%@ page session="true" import = "Servidor.CDdb" import = "java.util.*" import = "Servidor.CD" %>
<html>
<head>
 <title>Music Without Borders</title>
</head>
<body bgcolor="#33CCFF">
 <font face="Times New Roman,Times" size="+3">
  Music Without Borders
 </font>
 <hr><p>
 
  
 

 <center>
 <form name="shoppingForm" 
   action="/RepasoWebcd/ServirPeticion" 
   method="POST">
 <b>CD:</b> 
 <select name=CD>
 <% CDdb cdo = new CDdb(); 
  List eList = cdo.getCDlist();
  for (int i = 0; i < eList.size(); i++)
  {
	  CD cd = (CD) eList.get(i);//recorrem llista CD
	 
  %>
  <option><%= cd.getAlbum()%> | <%=cd.getArtist()%> | <%=cd.getCountry()%> | <%=cd.getPrice()%></option>

   <% } %>
 </select>
  
 <b>Quantity: </b><input type="text" name="qty" SIZE="3" value=1>
 <input type="hidden" name="action" value="ADD">
 <input type="submit" name="Submit" value="Add to Cart">
 </form>
 </center>
 <p>
 <jsp:include page="Cart.jsp" flush="true" />
</body>
</html>