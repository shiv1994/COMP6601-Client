
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.rmi.server.RMIServerSocketFactory; 
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import sun.rmi.registry.RegistryImpl; 

public class Server implements RMIServerSocketFactory, Serializable{

	public Server(){
		try{
			RegistryImpl impl = new RegistryImpl(5000);
		}
		catch(RemoteException e){
			System.out.println(e);
		}

		try{
			ClientVotingInterface stub = (ClientVotingInterface) new ClientVotingRemote(5000);
			Naming.rebind("rmi://localhost:5000/voting", stub);
			System.out.println("Server up.");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String args[]){
		new Server();
	}

	public ServerSocket createServerSocket(int port) throws IOException{
		ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
		ServerSocket socket = factory.createServerSocket(port);
		return socket;
	}
}