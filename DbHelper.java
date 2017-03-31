import java.sql.*;

// maybe make this a Singleton Class
public final class DbHelper{

    // JDBC Driver name
    private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";

    // Database names
    private static final String DB_NAME = "voting";

    // DB URLS
    private static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
    //private static final String DB_URL_SHADOW = "jdbc:mysql://localhost/";

    // DB Credentials - to be replaced by admin entering credentials
    private static final String USERNAME="root";
    private static final String PASSWORD="";

    private static boolean tablesCreated=false;

    private Connection connection=null;

    public DbHelper(){
        setUpConnection();
    }

    private void setUpConnection(){
        try{
            //registering JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // opening a connection to database
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to database...");
        }
        catch (SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    public void createTables(){

        if(!tablesCreated){
            // database tables not yet created
            Statement stmt = null;
            try{
                // create all tables
                stmt = connection.createStatement();
                stmt.executeUpdate(CampaignContract.CREATE_TABLE);
                stmt.executeUpdate(CandidateContract.CREATE_TABLE);
                stmt.executeUpdate(VotingContract.CREATE_TABLE);
                tablesCreated = true;
                System.out.println("Tables successfully created.");
            }
            catch (SQLException e){
                System.out.println("SQL Error: " + e.getMessage());
            }
            finally{
                try{
                    if(stmt != null)
                        stmt.close();
                }
                catch (SQLException e){
                    System.out.println("SQL Error: " + e.getMessage());
                }
            }

        }
        else
            System.out.println("Tables already exist");
    }
}