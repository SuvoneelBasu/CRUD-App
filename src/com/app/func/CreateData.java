package com.app.func;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CreateData {
	private static final String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
	public void Create() {
		Connection con = null;
		Scanner sc = null;
		PreparedStatement pst = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis=new FileInputStream("src\\com\\app\\func\\db.properties");
			prop.load(fis);
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("pwd");
			
			con = DriverManager.getConnection(url, user, password);
			if(con != null) {
				pst = con.prepareStatement(query);
			}
			if(pst != null) {
				sc = new Scanner(System.in);
				if(sc != null) {
					System.out.println("Enter Employee Id: ");
					String id = sc.nextLine();
					System.out.println("Enter Employee Name: ");
					String name = sc.nextLine();
					System.out.println("Enter Employee email id: ");
					String mail = sc.nextLine();
					System.out.println("Enter Employee Address: ");
					String address = sc.nextLine();
					System.out.println("Enter Employee Salary: ");
					String salary = sc.nextLine();
					pst.setString(1, id);
					pst.setString(2, name);
					pst.setString(3, mail);
					pst.setString(4, address);
					pst.setString(5, salary);
					
					int i = pst.executeUpdate();
					
					System.out.println("The number of rows affected are: "+i);
				}
			}
		} catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null) {
					pst.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	
}
