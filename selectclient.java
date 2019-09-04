import java.rmi.*;
import java.net.*;
import java.util.*;
import java.rmi.registry.*;

public class selectclient
{
 public static void main(String[] args)
  {
     //String rmiURL = "rmi://" + args[0] + "/Select-Server";
	try
	{
		Registry userreg = LocateRegistry.getRegistry(5000);	
		selectint sel=(selectint)userreg.lookup("Select-Server");
		//selectint sel = (selectint)Naming.lookup(rmiURL);
		HashMap hn2 = sel.executeselect();
		int sz = hn2.size();
		System.out.println(sz);
		
		for(int i=1; i<=sz;i++)
		{
			if(hn2.containsKey(new Integer(i)))
			{
			System.out.println(i + ":" + hn2.get(new Integer(i)));
			}
		}
	}

	catch(Exception e)
	{
	  System.out.print("Hello"+e);
	}
  }
}