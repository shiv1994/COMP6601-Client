import java.util.*;
import java.rmi.*;


public interface ClientVotingInterface extends Remote{

	public ArrayList<Candidate> fetchCandidates() throws RemoteException;

	public boolean castVote(String candidate) throws RemoteException;

}