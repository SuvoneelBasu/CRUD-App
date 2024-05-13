package com.app.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.app.func.CreateData;
import com.app.func.DeleteData;
import com.app.func.ReadData;
import com.app.func.UpdateData;



public class Menu {
	
	
	public void menuDrive() {
		Scanner sc = new Scanner(System.in);
		CreateData cr = new CreateData();
		ReadData rd = new ReadData();
		UpdateData up = new UpdateData();
		DeleteData dd = new DeleteData();
		while(true) {
			System.out.println("Enter 1 for Inserting Data");
			System.out.println("Enter 2 for Reading Data");
			System.out.println("Enter 3 for Updating Data");
			System.out.println("Enter 4 for Deleting Data");
			System.out.println("Enter 0 to exit");
			System.out.print("Enter operation choice for CRUD:");
			
			char ch = sc.nextLine().charAt(0);
			//String ch = br.readLine();
			System.out.println(ch);
			switch (ch) {
			case '1':
				cr.Create();
				
				break;
			case '2':
				rd.read();
				break;
			case '3':
				up.update();
				break;
			case '4':
				dd.delete();
				break;
			case '0':
				System.out.println("GoodBye!!!!!");
				System.exit(0);
			default:
				System.out.println("Enter any other choice....You have entered a wrong choice.....");
			}
		}		
		
	}
}
