package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.cj.jdbc.Driver;

public class GetDataMySql {

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
         String query="select * from emp";
         //executeQuery or ExecuteUpdate query
         ResultSet results = statement.executeQuery(query);
           //check data is fetching or not
         while(results.next()) {
        	 String data=results.getString(1)+" "+results.getString(2)+"  "+results.getString(3);
        		System.out.println(data);
         }

         }
         //close the database connection.
         finally {
        	 connection.close();
		}

	}

}
