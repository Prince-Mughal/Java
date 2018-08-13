/*
You may modify or reproduce.
Time: 02:06:17am Tuesday
Date: 14-08-2018
Email: mughalb9291@gmail.com
Bugs and Criticisms are warmly welcome :) 
Happy Independence Day!
Live Long Pakistan!
(additional methods will be updated soon)
*/
package company;
/* Connection Helper */
import java.sql.DriverManager;
/* Connection Handler */
import java.sql.Connection;
/* Trace Error */
import java.sql.SQLException;
/* SQL Statement Handler */
import java.sql.Statement;
/* Result Processor */
import java.sql.ResultSet;
/* Load Database Driver */
import com.mysql.jdbc.Driver;
/* Non-inheritable Database Class */
final public class Database {
    /*  Table , Database, User, Password  */
    private final String URL = "jdbc:mysql://localhost";
    private String databaseUserName;
    private String databaseUserPassword;
    private String databaseName;
    private String databaseTableName;
    /* Connection , SQL Statement , Process Result */
    private Connection connection;
    private Statement  statement;
    private ResultSet  resultSet;
    /* Default Constructor */
    public Database(){
        this("N/A","N/A");
    }
    /* User, Password */
    public Database(String databaseUserName,
                    String databaseUserPassword){
        this.databaseUserName     = databaseUserName;
        this.databaseUserPassword = databaseUserPassword;
    }
    /* User, Password, Database */
    public Database(String databaseUserName,
                    String databaseUserPassword,
                    String databaseName){
        this.databaseUserName     = databaseUserName;
        this.databaseUserPassword = databaseUserPassword;
        this.databaseName         = databaseName;
    }
    /* User, Password , Database , Table */
    public Database(String databaseUserName,
                    String databaseUserPassword,
                    String databaseName,
                    String databaseTableName){
        this.databaseUserName     = databaseUserName;
        this.databaseUserPassword = databaseUserPassword;
        this.databaseName         = databaseName;
        this.databaseTableName    = databaseTableName;
    }
    /* Set User */
    public void setDatabaseUserName(String databaseUserName){
        this.databaseUserName     = databaseUserName;
    }
    /* Set Password */
    public void setDatabaseUserPassword(String databaseUserPassword ){
        this.databaseUserPassword = databaseUserPassword;
    }
    /* Set Database */
    public void setDatabaseName(String databaseName ){
        this.databaseName         = databaseName;
    }
    /* Set Table */
    public void setDatabaseTableName(String databaseTableName){
        this.databaseTableName    = databaseTableName;
    }
    /* Get User */
    public String getDatabaseUserName(){
        return databaseUserName;
    }
    /* Get Password */
    public String getDatabaseUserPassword(){
        return databaseUserPassword;
    }
    /* Get Database */
    public String getDatabaseName(){
        return databaseName;
    }
    /* Get Table */
    public String getDatabaseTableName(){
        return databaseTableName;
    }

    /* Connect to mysql Server */
    public boolean connectToMySqlServer(){
        try{
            connection = DriverManager.getConnection(
                                            URL,
                                            databaseUserName,
                                            databaseUserPassword);
            statement = connection.createStatement();
            return true;
        }catch(SQLException sql){
            return false;
        }
    }
    /* Connect to database */
    public boolean connectToDatabase(){
        try{
            statement.executeUpdate("USE "+databaseName);
            return true;
        }catch(SQLException sql){
            return false;
        }
    }
    /* Create table */
    public boolean createTable(String attribute){
        String table = "CREATE TABLE "+
                        databaseTableName+"( "
                        +attribute /* Type , Attribute , Keys */
                        +" )";
        try{
            statement.executeUpdate(table);
            return true;
        }catch(SQLException sql){
            return false;
        }
    }
    /* Insert a row  */
    public boolean insertInto(String data){
        String insert = "INSERT INTO "+
                        databaseTableName+" VALUES( "
                        +data /* comma separated values in Order */
                        +" )";
        try{
            statement.executeUpdate(insert);
            return true;
        }catch(SQLException sql){
            return false;
        }
    }
    
    
}
