package gojpcms.database;


/**
 * Abstract class DBConnection - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
import java.sql.*;
public abstract class DBConnection
{
    // instance variables - replace the example below with your own
    protected int DB_VERSION = 1;
    protected Connection dbconnection;
    protected Statement stmt;
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost/GOJPCM", DB_PASS = "oshany1991", DB_USER = "root";
    

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public DBConnection() throws SQLException
    {
        // put your code here
        this.connect();
    }
    
    public void openConnect(){
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            
            //Open database connection
            System.out.println("Connecting to database..");
            this.dbconnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            this.stmt = this.dbconnection.createStatement();
            
        }catch(SQLException e){
            System.out.print("There was a problem connecting with database");
            e.printStackTrace();
        }
    }
    
    public void closeConnection() throws SQLException{
       this.dbconnection.close();
    }
    
    public void closeStatement(){
       this.stmt.close();
    }
    
    public ResultSet query(String sql) throws SQLException{
        return this.stmt.executeQuery(sql);         
    }
    
    
    
}
