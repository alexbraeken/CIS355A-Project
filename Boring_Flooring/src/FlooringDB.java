import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class FlooringDB {

	 private String url = "jdbc:mysql://devry.edupe.net:4300/CIS355A_1429";
	 private String login = "3902";
	 private String password = "1234567890";
	 private Connection conn;
	 private Statement myquery;
	 private ResultSet results;
	 private DefaultTableModel custModel;
	 private PreparedStatement insertQ;
	 private String query;
	
	 public FlooringDB()
	 {
		
	 }
	 
	 public void addOrder(String name, String address, String fType, double area, double cost, String zip)
	 {
		 query = "INSERT into flooring (Customer_Name, Customer_Address, Flooring_Type, Floor_Area, Floor_Cost, Zip_Code ) values (?, ?, ?, ?, ?, ?)";
			
		 try{    
				conn=DriverManager.getConnection(  
				url, login, password); 
				System.out.println("Connected!");
				
				insertQ = conn.prepareStatement(query);
				insertQ.setString(1, name);
				insertQ.setString(2,address);
				insertQ.setString(3,fType);
				insertQ.setDouble(4,area);
				insertQ.setDouble(5,cost);
				insertQ.setString(6,zip);
				insertQ.execute();
				
				conn.close();
			}
			catch(Exception e){ 
				System.out.println(e);
			} 
	 }
	 public DefaultTableModel getList()
	 {
		 Vector<String> cnames = new Vector<String>();
		 Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		 try
		 {
         //get connection
         conn = DriverManager.getConnection(url, login, password);
         System.out.println("Connected!");
         //process query to retrieve the data
         myquery = conn.createStatement();
         results = myquery.executeQuery("Select * from flooring");
         //use metadata to get column names
         ResultSetMetaData md = results.getMetaData();
         int num = md.getColumnCount();
         //create a Vector object and add column names to it
        
         for (int i = 1; i <= num; i++)
         {
             cnames.add(md.getColumnName(i));
         }         
 

         //process each row of result set
        
         while (results.next()) 
         {
             Vector<Object> vector = new Vector<Object>();
             for (int columnIndex = 1; columnIndex <= num; columnIndex++) 
             {
                 vector.add(results.getObject(columnIndex));
             }
             data.add(vector);
         }
         
         conn.close();
         
        
     }
     catch (SQLException ex)
     {
         ex.printStackTrace();
         System.out.println("Database error");
     }
		
		 return new DefaultTableModel(data, cnames);
		 
	}
     


	
	
}
