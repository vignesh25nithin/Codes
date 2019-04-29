import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnectivity {
	//static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Student";
		/*static final String DB_URL = "jdbc:sqlserver://localhost:1433;databasename=Student";
		static final String DB_URL = "jdbc:sqlserver://IMCHLT080\\SQLEXPRESS;databaseName=Student";
		static final String USER = "vignesh";
		static final String PASS = "12345";*/
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
	   Connection conn = null;
	   Statement stmt = null;
	   
	   try{  
		   //STEP 2: Register JDBC driver
	      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      //STEP 3: Open a connection
	   	  Scanner obj=new Scanner(System.in);
	   	  System.out.println("Enter the DB user name");
	   	  String user=obj.nextLine();
	   	  System.out.println("Enter the DB user pwd");
	   	  String pwd=obj.nextLine();
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,user,pwd);
	      //conn = DriverManager.getConnection(DB_URL,"vignesh","12345");
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
		      while(true) {
		    	  System.out.println("enter the choice:\n 1) add data to db \n 2)display db data \n 3)delete record \n press (num > 3) to exit ");
		    	  int choice=obj.nextInt();
		    	  obj.nextLine();
			      switch(choice) {
				      case 1:
					      /*
					       * ADD data to db
					       */
					      
					      System.out.println("enter name of student :");
					      String name=obj.nextLine();
					      System.out.println("enter age of student :");
					      int Sage=obj.nextInt();
					      obj.nextLine();
					      System.out.println("enter Date of birth (yyyy-mm-dd) of student :");
					      String dateDob=obj.nextLine();
					      System.out.println("enter marks(out of 1200) of student :");
					      int marks=obj.nextInt();
					      obj.nextLine();
					      System.out.println("enter Id of student :");
					      int Sid=obj.nextInt();
					      obj.nextLine();
					      PreparedStatement ps = conn.prepareStatement("INSERT INTO Students (Sname,Sage,Sdob,Stotalmarks,Sid) VALUES (?, ?, ?, ?, ?)");
					      ps.setString(1, name);
					      ps.setInt(2, Sage);
					      ps.setString(3, dateDob);
					      ps.setInt(4, marks);
					      ps.setInt(5, Sid);
					      ps.executeUpdate();  
					      break;
			     
				      case 2:
					      /*
					       * display details
					       */
					      System.out.println("displaying table data : ");
					      String sql;
					      sql = "SELECT * FROM Students";
					      ResultSet rs = stmt.executeQuery(sql);
					      
					      //STEP 5: Extract data from result set
					      while(rs.next()){
					         //Retrieve by column name
					      /* int id  = rs.getInt("Sid");
					         int age = rs.getInt("Sage");
					         String first = rs.getString("Sname");
					         //String last = rs.getString("last");
					         //Display values
					         System.out.print("ID: " + id);
					         System.out.print(", Age: " + age);
					         System.out.println(", First name: " + first);
					         System.out.println(", Last: " + last); 
					         */
					    	  System.out.println("id :"+rs.getInt("Sid"));
					    	  System.out.println("name :"+rs.getString("Sname"));
					    	  System.out.println("Date of birth:"+rs.getString("Sdob"));
					    	  System.out.println("total marks :"+rs.getInt("Stotalmarks"));
					    	  System.out.println("age of student: "+rs.getInt("Sage"));
					    	  System.out.println("***************************");
					      }
					      break;
			    	  
				      case 3:
					    	/*
					    	 * delete a record based on id
					    	 */
					      System.out.println("Enter the id for deletion of record:");
					      int did=obj.nextInt();
					      
					      String query = "delete from Students where Sid = ? ";
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
					      preparedStmt.setInt(1, did);
					      
		
					      // execute the preparedstatement
					      preparedStmt.execute(); 
					     
					      System.out.println("record deleted sucessful");
					      break;
					      	
				      default :
				    	  stmt.close();
					      conn.close();
				    	  System.exit(0);
			    	 
	  }
	   }
	    }
	   catch(SQLException se){
			      //Handle errors for JDBC
				   System.out.println(se.getMessage());
			      //se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			     // e.printStackTrace();
			      System.out.println(e.getMessage());
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         //se.printStackTrace();
			    	  System.out.println(se.getMessage());
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");

	}

}
