import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class QueryGenerator {
	public static Connection connection = null;
	static final String USER = "user";
	static final String PASS = "password";
	static final String DB_URL = "jdbc:jtds:sqlserver://dbhost/dbname;instance=instanceName";
	static final String Env = "_DEV"; 
	
	
	public static void getdata(String Tablename, Connection conn,String[] st)
			throws SQLException {
		try{
			
			Statement statement = conn.createStatement();
			List<String> list = new ArrayList<>();
			int[] row = {2,3,4,5,6,7};
			String Values="",col = ""; int count=5;
			ResultSet rs = statement.executeQuery("select top(1) * from " + Tablename + " with(nolock)");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			for(int i=0;i<st.length;i++){
				rs = statement.executeQuery("SELECT * FROM " + Tablename
					+ " WHERE " + rsmd.getColumnName(3) + " = '"
					+ st[i] + "'");
				
				while (rs.next()) {
					for (int j = 0; j <= count; j++) {
						col = (j != count) ? col + rsmd.getColumnName(row[j]) + ","
								: col + rsmd.getColumnName(row[j]);
						
						Values = (rs.getString(row[j]) != null) ? ((j != count) ? Values
								+ "'" + rs.getString(row[j]) + "'" + ","
								: Values + "'" + rs.getString(row[j]) + "'")
								: ((j != 5) ? Values + rs.getString(row[j]) + ","
										: Values + rs.getString(row[j]));
						
					}
					String query = "INSERT INTO [tableName].[dbo].["+ Tablename +"]" + "(" + col
							+ ")values (" + Values + ");";
					
					list.add(query);
					Values = "";
					col = "";
				}
				
				if(Env=="_DEV"){
				File dir = new File("d:/Eclipse_workspace/Sql_Zaps/"+st[i]+"/");
				dir.mkdirs();
				}
				String filepath = "d:/Eclipse_workspace/Sql_Zaps/"+st[i]+"/"+st[i]+""+Env+".sql" ;
				
				
				Iterator<String> iterator = list.iterator();
				FileWriter fw = new FileWriter(filepath);
				while (iterator.hasNext()) {
					fw.write(iterator.next());
					fw.write("\n");
				}
				fw.close();
				list.clear();
			}
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Scanner obj = new Scanner(System.in);
			/* unique column based on which data needs to be generated */
			String[] PF_name = 
				{"Customer"};
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("connection success");
		    /*name of the table */
			String Tablename = "";
			getdata(Tablename, conn ,PF_name);
			
			conn.close();
							
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}
