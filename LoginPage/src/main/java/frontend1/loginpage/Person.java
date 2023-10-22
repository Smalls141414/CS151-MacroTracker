/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package frontend1.loginpage;

/**
 *
 * @author nikha
 */


import java.util.ArrayList;

public class Person {
    
    
    public String name, username, password, email;
    public static ArrayList<Person> loginList = new ArrayList<>();
    
    //Each person has 4 attributes
    
    public Person (String name, String username, String password, String email){
    
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
}
    
    //Takes in the username and password entered by user and checks if exist in the arraylist database.
    //LOGIN
    
    
    public static boolean Login(String username, String password)
    {
        for (Person i : loginList)
        {
            if(i.getUsername().equals(username) && i.getPassword().equals(password))
            {
                System.out.println("Logged in Successfully!");
                return true;
            }
        }
        
        System.out.println("Logged in NOT Successfully!");
        return false;
    }
    
    //REGISTER NEW USER
    
    public static void Register(String name, String username, String password, String email)
    {
        loginList.add(new Person(name, username, password, email));
    }
    
    //getter for username
    
    public String getUsername()
    {
        return username;
    }
    
    //getter for password
    public String getPassword()
    {
        return password;
    }
    
    public static String JPasswordFieldToString(char[] a)
    {
        String output = "";
        for (char i : a)
        {
            output += i;
        }
        
        return output;
    }

//    public static void main(String[] args) {
//        //System.out.println("Hello World!");
//    }
}
