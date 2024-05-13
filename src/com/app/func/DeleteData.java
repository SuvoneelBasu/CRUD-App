package com.app.func;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class DeleteData {
String query = "DELETE FROM EMPLOYEE WHERE ID=";
	
	public void delete() {
		Connection con = null;
		Scanner sc = null;
		Statement st = null;
		
		try {
			Properties prop = new Properties();
			FileInputStream fis=new FileInputStream("src\\com\\app\\func\\db.properties");
			prop.load(fis);
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("pwd");
			
			con = DriverManager.getConnection(url, user, password);
			if(con != null) {
				st=con.createStatement();
			}
			if(st != null) {
				
				sc = new Scanner(System.in);
				System.out.println("Enter the Id for which data is needed to be deleted: ");
				String id = sc.nextLine();
				String query1=query+id;
				boolean i= st.execute(query1);
					
			}
			
			
		} catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(st!=null) {
					st.close();
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
