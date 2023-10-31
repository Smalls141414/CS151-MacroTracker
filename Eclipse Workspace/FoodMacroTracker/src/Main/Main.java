package Main;

import GUI.LoginPage;
import Person.Person;
import SQLite.DatabaseManager;


public class Main {

	public static void main(String[] args) {
		
//		//test person
//		Person a = new Person("Nik", "Nik@123");
//		
//		DatabaseManager dbManager = new DatabaseManager();
//        // Insert a userID into the table
//        dbManager.insertUserName(a.getUserName(), a.getPassword());
//        // Close the database connection when done
//        dbManager.closeConnection();
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.setVisible(true);
		
		
		

	}

}
