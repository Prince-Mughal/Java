
/* Test File */
package company;

public class Main {
    public static void main(String[] args){
        Database database = new Database("root","");
        if(database.connectToMySqlServer()){
            System.out.println("Connected to MySQL Server.");
        }
        database.setDatabaseName("LetsChat");
        if(database.connectToDatabase()){
            System.out.println("Connected to Database.");
        }
        database.setDatabaseTableName("Student");
        if(database.createTable("STU_ID INT NOT NULL,"
                              + "STU_NAME VARCHAR(48) NOT NULL,"
                              + "PRIMARY KEY (STU_ID)")){
            System.out.println("Table Created.");
        }
        if(database.insertInto("001,\"Prince Mughal\"")){
            System.out.println("Record Inserted.");
        }
        if(database.close()){
            System.out.println("Connection has been closed.");
        }
    
    }
    
}
