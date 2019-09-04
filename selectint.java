import java.rmi.*;
import java.util.*;

public interface selectint extends Remote
{

	HashMap executeselect() throws RemoteException;
	
}