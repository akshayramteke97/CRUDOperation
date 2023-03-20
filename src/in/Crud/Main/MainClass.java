package in.Crud.Main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import in.Crud.Method.ICrudMethod;
import in.Crud.MethodObject.CrudMethodObject;

public class MainClass {
	static {
		System.out.println("			******Welcome to CRUD operation Project******");
		System.out.println("Press 1 for insertion operation");
		System.out.println("Press 2 for select operation");
		System.out.println("Press 3 for update operation");
		System.out.println("Press 4 for delete operation");
		System.out.println("Press 5 for exit");
	}
	public static void main(String [] args) {
		
		ICrudMethod crudMethod=CrudMethodObject.crudUtilMethod();
		
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Enter the option shown above :::");
		System.out.println();
		
		
		int userEntry=scan.nextInt();
		if(userEntry==1) {
			try {
				crudMethod.insert();
			}
			catch(IOException | SQLException se) {
				se.printStackTrace();
			}
		}
		else if(userEntry==2) {
			
			try {
				crudMethod.select();
			}catch(IOException | SQLException se){
				se.printStackTrace();
			}
		}
		else if(userEntry==3) {
			try {
				crudMethod.update();
			}
			catch(IOException | SQLException se) {
				se.printStackTrace();
			}
		}
		else if(userEntry==4) {
			try {
				crudMethod.delete();
			}catch(IOException | SQLException se) {
				se.printStackTrace();
			}
		}
		else if(userEntry==5) {
			System.exit(1000);
		}
		else {
			System.out.println("Enter value is invalid");
		}
	}
}
