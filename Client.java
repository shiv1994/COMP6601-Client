import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.*; 
import java.rmi.server.RMIClientSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class Client implements RMIClientSocketFactory, Serializable{

	public static void main(String args[]){
		try{
			ClientVotingInterface stub = (ClientVotingInterface) Naming.lookup("rmi://localhost:5000/voting");
			System.out.println(stub.fetchItems());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public Socket createSocket(String host, int port) throws  IOException{
		SocketFactory factory = SSLSocketFactory.getDefault();

		Socket socket = factory.createSocket(host, port);

		return socket;
	}
}