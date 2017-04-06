import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mdls8 on 4/5/2017.
 */
public interface AdminVotingInterface extends Remote {

    public boolean addCampaign(Campaign campaign) throws RemoteException;

    public ArrayList<Report> getReports() throws RemoteException;
}
