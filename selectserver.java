import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;

public class selectserver
{
  public static void main(String[] args)
{
  try
   {
   	
	selectimpl sel= new selectimpl();
	Registry userreg = LocateRegistry.createRegistry(5000);
	userreg.rebind("Select-Server",sel);
	System.out.println("server is readyyyyy");
   }
  catch(Exception e)
   {
     System.out.println(" "+e);
   }
}
}