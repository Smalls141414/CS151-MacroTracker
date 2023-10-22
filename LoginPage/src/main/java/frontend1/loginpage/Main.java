/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend1.loginpage;

import javax.swing.*;

/**
 *
 * @author nikharvdomadiya
 */
public class Main {
    
    public static void main (String [] args){
        
    JFrame frame = new JFrame("Frame");
    JPanel panel = new JPanel();
    panel.add(new LoginPageGUI());
    
    frame.getContentPane().add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
        
        
    }
    
}
