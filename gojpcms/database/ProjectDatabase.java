package gojpcms.database;

import java.sql.SQLException;


/**
 * Write a description of class ProjectData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectDatabase extends DBConnection
{
    // instance variables - replace the example below with your own
    final static String DB_TABLE = "projects";

    /**
     * Constructor for objects of class ProjectData
     * @throws SQLException 
     */
    public ProjectDatabase() throws SQLException
    {
        // initialise instance variables
        super();
    }
}
