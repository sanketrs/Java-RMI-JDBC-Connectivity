import java.rmi.*;
import java.sql.*;
import java.rmi.server.*;
import java.util.*;

public class selectimpl extends UnicastRemoteObject implements selectint
{
  public selectimpl() throws RemoteException
	{

	}
	
  public HashMap executeselect() throws RemoteException
   {
	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String dburl = "jdbc:odbc:DSN1";
	String query = "select * from Student";
	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	HashMap hm=null;
	try
	{
		Class.forName(driver);	
	}
	catch(ClassNotFoundException e)
		{
System.out.println(" Class not found"+e);
		}

try{
	con=DriverManager.getConnection(dburl);
	stmt=con.createStatement();
	rs=stmt.executeQuery(query);
	hm=new HashMap();
	while(rs.next())
	 {
	   int rno=rs.getInt(1);
	   String sname=rs.getString(2);
	   hm.put(new Integer(rno),sname);
	 }  
       con.close(); 
}
catch(Exception e)
  {
System.out.println(" Class not found"+e);
  }
	return(hm);
    }
}