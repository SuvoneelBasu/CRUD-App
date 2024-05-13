package com.app.func;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class UpdateData {
	private static final String query1 = "UPDATE EMPLOYEE SET NAME=? WHERE ID=?";
	private static final String query2 = "UPDATE EMPLOYEE SET MAIL=? WHERE ID=?";
	private static final String query3 = "UPDATE EMPLOYEE SET ADDRESS=? WHERE ID=?";
	private static final String query4 = "UPDATE EMPLOYEE SET SALARY=? WHERE ID=?";
	public void update() {
		Connection con = null;
		Scanner sc = null;
		PreparedStatement pst = null;
		String key = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis=new FileInputStream("src\\com\\app\\func\\db.properties");
			prop.load(fis);
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("pwd");
			
			con = DriverManager.getConnection(url, user, password);
			if(con != null) {
				sc = new Scanner(System.in);
				if(sc != null) {
					System.out.println("Enter the data to be updated:");
					System.out.println("Enter 1 for Name update:");
					System.out.println("Enter 2 for Mail update:");
					System.out.println("Enter 3 for Address update:");
					System.out.println("Enter 4 for Salary update:");
					String j = sc.nextLine();
					switch (j) {
					case "1": {
						System.out.println("Enter Updated Employee Name: ");
						key = sc.nextLine();
						pst = con.prepareStatement(query1);
						break;
					}
					case "2": {
						System.out.println("Enter Updated Employee Mail: ");
						key = sc.nextLine();
						pst = con.prepareStatement(query2);
						break;
					}
					case "3": {
						System.out.println("Enter Updated Employee Address: ");
						key = sc.nextLine();
						pst = con.prepareStatement(query3);
						break;
					}
					case "4": {
						System.out.println("Enter Updated Employee Salary: ");
						key = sc.nextLine();
						pst = con.prepareStatement(query4);
						break;
					}
					default:
						System.out.println("Enter a valid option");
						update();
						
					}
			}
			if(pst != null) {
				
					System.out.println("Enter the Id for which change is needed: ");
					String id = sc.nextLine();
					pst.setString(1, key);
					pst.setString(2, id);
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
