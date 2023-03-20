package in.Crud.Method;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CrudMethodImpl implements ICrudMethod{
	//instance variable of different calss
	Connection connection =null;
	PreparedStatement prstmt=null;
	ResultSet resultSet=null;
	Scanner scan=null;
	
	String name=null;
	String gender=null;
	String address=null;
	
	
	//connection method
	public Connection getCrudConnection() throws IOException, SQLException {
		FileInputStream file=new FileInputStream("src\\SqlUserPassword");
		Properties properties=new Properties();
		properties.load(file);
		connection =DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		return connection;
	}
	public void insert() throws IOException, SQLException {
		int id=0;
		connection=getCrudConnection();
		String sqlStatement="insert into student(`id`,`sname`,`saddress`,`sgender`) values(?,?,?,?)";
		if(connection !=null) {
			prstmt=connection.prepareStatement(sqlStatement);
			scan=new Scanner(System.in);
			if(scan!=null) {
				System.out.print("Enter the student id :: ");
				id=scan.nextInt();
				System.out.print("Enter the student name : ");
				name=scan.next();
				System.out.print("Enter the student address : ");
				address=scan.next();
				System.out.print("Enter the student gender : ");
				gender =scan.next();
			}
			prstmt.setInt(1, id);
			prstmt.setString(2, name);
			prstmt.setString(3, address);
			prstmt.setString(4,gender);
			prstmt.executeUpdate();
			System.out.println("successfully executed the values...");
		}
	}
	public void select() throws IOException,SQLException{
		connection =getCrudConnection();
		int id=0;
		String sqlStatement="select id,sname,saddress,sgender from student where id=?";
		if(connection!=null) {
			prstmt=connection.prepareStatement(sqlStatement);
			scan=new Scanner(System.in);
			if(scan!=null) {
				System.out.print("Enter the id : ");
				id=scan.nextInt();
			}
			prstmt.setInt(1, id);
			resultSet=prstmt.executeQuery();
			if(resultSet!=null) {
				if(resultSet.next()) {
					System.out.println("SID\tSNAME\tSADDRESS\tSGENDER");
					int sid=resultSet.getInt(1);
					String name=resultSet.getString(2);
					String address=resultSet.getString(3);
					String gender=resultSet.getString(4);
					System.out.println(sid+"\t"+name+"\t"+address+"\t\t"+gender);
				}
				else {
					System.out.println("record not found of such id you entered");
				}
			}
		}
	}
	public void delete() throws IOException, SQLException {
		int id=0;
		connection=getCrudConnection();
		String sqlStatament="delete from student where id=?";
		if(connection!=null) {
			prstmt=connection.prepareStatement(sqlStatament);
			scan=new Scanner(System.in);
			if(scan!=null) {
				System.out.print("Enter the id to delete row : ");
				id=scan.nextInt();
			}
			prstmt.setInt(1, id);
			prstmt.executeUpdate();
			System.out.println("Delete operation executed successfully..");
		}		
	}
	public void update() throws IOException, SQLException {
		int id=0;
		connection=getCrudConnection();
		String sqlStatement="update student set sname=?,saddress=?,sgender=? where id=?";
		if(connection!=null) {
			prstmt=connection.prepareStatement(sqlStatement);
			scan=new Scanner(System.in);
			if(scan!=null) {
				System.out.print("Enter the id :: ");
				id=scan.nextInt();
				System.out.print("Enter the student name :");
				name=scan.next();
				System.out.print("Enter the student address : ");
				address=scan.next();
				System.out.println("Enter the student gender : ");
				gender=scan.next();
			}
			else {
				System.out.println("record not available");
			}
			prstmt.setInt(4, id);
			prstmt.setString(1, name);
			prstmt.setString(2, address);
			prstmt.setString(3, gender);
			prstmt.executeUpdate();
			System.out.println("Update operation executed successfully");
		}	
	}
}
