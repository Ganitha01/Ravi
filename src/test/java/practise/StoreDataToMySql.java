package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.cj.jdbc.Driver;

public class StoreDataToMySql {

	public static void main(String[] args) throws SQLException {
		 Connection connection=null;
         try {
         //step 1: Driverclass
         Driver database=new Driver();
         //step2: register the driver
         DriverManager.registerDriver(database);
         //step3: connectin
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
         //step4 after connection create statement
         Statement statement = connection.createStatement();
         //create query
         Random ran=new Random();
         int rannum=ran.nextInt(1000);
         String ename="Ravi"+rannum;
         String ejob="test"+rannum;
         String query="insert into emp values('"+rannum+"','"+ename+"','"+ejob+"')";
         
         //executeQuery or ExecuteUpdate query
         int result = statement.executeUpdate(query);
		    if(result==1)
		    	System.out.println("One row created");
		    else
		    	System.out.println("Not created");


         }
         //close the database connection.
         finally {
        	 connection.close();
		}

 
	}

}
