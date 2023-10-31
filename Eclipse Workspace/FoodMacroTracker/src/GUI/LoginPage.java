package GUI;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import SQLite.DatabaseManager;


@SuppressWarnings("serial")
public class LoginPage extends JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
    }

    private void initComponents() {

        jSplitPane1 = new JSplitPane();
        jLabel2 = new JLabel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        Username = new JTextField();
        jLabel3 = new JLabel();
        Password = new JPasswordField();
        loginButton = new JButton();
        registerButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Macro Tracker");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(965, 400));
        setMinimumSize(new java.awt.Dimension(965, 400));
        setName("loginFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(965, 400));
        setSize(new java.awt.Dimension(965, 400));

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setIcon(new ImageIcon(getClass().getResource("Asparagus-spears-57ba27e.jpg"))); // NOI18N
        jSplitPane1.setLeftComponent(jLabel2);

        jPanel3.setBackground(new java.awt.Color(255, 239, 209));
        jPanel3.setMaximumSize(getPreferredSize());
        jPanel3.setMinimumSize(getPreferredSize());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        jLabel1.setText("Username");

        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        jLabel3.setText("Password");

        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(loginButton)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(Username, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton)
                    .addComponent(Password, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(367, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Username, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Password, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(registerButton))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel3);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	
    }                                        

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	
    	db.connectToDatabase();
    	
    	Boolean bool = db.checkCredentials(Username.getText(), getPasswordString(Password.getPassword()));
    	
    	if (bool)
    	{
    		JOptionPane.showMessageDialog(null, "Logged in Successfully!");
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "User not Found :)");
    	}
    	
    	db.closeConnection();
    	
    }                                           

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException {                                               
        // TODO add your handling code here:
    	db.connectToDatabase();
    	
    	try {
    		db.insertUserName(Username.getText(), getPasswordString(Password.getPassword()));
            // Registration was successful
    		JOptionPane.showMessageDialog(null, "Registration successful");
        } catch (SQLIntegrityConstraintViolationException e) {
            // Unique username constraint violated
        	JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.");
        } catch (SQLException e) {
            // Handle other database errors
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	db.closeConnection();
    	
    }                                              

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	
    	
    }     
    
    private static String getPasswordString(char[] a)
    {
    	String output = "";
    	
    	for (char i : a)
    	{
    		output += i;
    	}
    	
    	return output;
    }


    // Variables declaration - do not modify                     
    private JPasswordField Password;
    private JTextField Username;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JSplitPane jSplitPane1;
    private JButton loginButton;
    private JButton registerButton;
    private DatabaseManager db = new DatabaseManager();
    // End of variables declaration                   
}