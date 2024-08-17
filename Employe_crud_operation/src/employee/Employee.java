package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
 
   
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		  
		for(int i=1;i<6;i++) {
		System.out.println("1.Insert");
		System.out.println("2.Find");
		System.out.println("3.Update");
		System.out.println("4.Delete");
		System.out.println("5.FecthAll");
		System.out.println("6.Exit");
		System.out.println("Please choose the option");
		int option=sc.nextInt();

        

    try {
		Class.forName("com.mysql.jdbc.Driver");
Connection con	=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		   if(option==1) {
			   System.out.println("Insert");
			PreparedStatement ps   =con.prepareStatement("insert into jdbc_test.Employee values(?,?,?,?,?,?)");
			System.out.println("enter the id");
			int id=sc.nextInt();
			System.out.println("enter the name");
			String name=sc.next();
			System.out.println("enter the sal");
			Double sal=sc.nextDouble();
			System.out.println("enter the designation");
			String designation=sc.next();
			System.out.println("enter the address");
			String address=sc.next();
			System.out.println("enter the contact");
			String contact=sc.next();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, sal);
			ps.setString(4, designation);
			ps.setString(5, address);
			ps.setString(6, contact);
			ps.executeUpdate();
			System.out.println("Inserted");
		   }
		   else if(option==2) {
			   System.out.println("find");
			   System.out.println("enter the name");
				String name=sc.next();
				PreparedStatement ps=con.prepareStatement("select * from jdbc_test.employee where name=?");
				ps.setString(1, name);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					 int id= rs.getInt(1);
				    	String ename=  rs.getString(2);
				    	double sal=  rs.getDouble(3);
				    	String designation= rs.getString(4);
				    	String address= rs.getString(5);
				    	String contact=  rs.getString(6);
				    	System.out.println("eid="+id+","+"name="+name+","+"sal="+sal+","+"designation="+designation+"address="+address+","+","+"contact="+contact);
				      }
				      
					
				}
				

			
		   
				
		   
		   else if(option==3) {
			   System.out.println("update");
			   PreparedStatement ps=con.prepareStatement("update jdbc_test.Employee set name=? where eid=? ");
			   System.out.println("enter the name");
				String name=sc.next();
			   System.out.println("enter the id");
				int id=sc.nextInt();
				ps.setString(1, name);
				ps.setInt(2, id);
				ps.executeUpdate();
				System.out.println("updated");
		   }
		   else if(option==4) {
			   System.out.println("delete");
			   System.out.println("enter the id");
				int id=sc.nextInt();
			   PreparedStatement ps =con.prepareStatement("Delete from jdbc_test.Employee where eid=?");
				
				ps.setInt(1, id);
				ps.execute();
		   }
		   else if(option==5) {
			   System.out.println("fetchall");
			   Statement s=con.createStatement();
			   ResultSet rs=s.executeQuery("select * from jdbc_test.Employee");
		      while(rs.next()) {
		    	 int id= rs.getInt(1);
		    	String name=  rs.getString(2);
		    	double sal=  rs.getDouble(3);
		    	String designation= rs.getString(4);
		    	String address= rs.getString(5);
		    	String contact=  rs.getString(6);
		    	System.out.println("eid="+id+","+"name="+name+","+"sal="+sal+","+"designation="+designation+"address="+address+","+","+"contact="+contact);
		      }
		      
		   
		   }
		   else if(option==6) {
			   System.out.println("exit");
			   System.exit(0);
		    
		      }


	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
}