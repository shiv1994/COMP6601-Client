import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*; 

public class ClientVotingRemote extends UnicastRemoteObject implements ClientVotingInterface{

	public ClientVotingRemote(int port) throws RemoteException{
		super(port);
	} 

	public ArrayList<Item> fetchItems(){
		return new ArrayList<Item>();
	}

	public int test(){
		return 1; 
	}
}