import java.util.*;
import java.rmi.*;


public interface ClientVotingInterface extends Remote{

	public ArrayList<Item> fetchItems() throws RemoteException;

	public int test() throws RemoteException;
}