package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import SQLite.DatabaseManager;

@SuppressWarnings("serial")
class Option extends JFrame {
	private JLabel optionLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	//private JLabel gmailLabel;
	private JButton btnNewButton;
	private JButton editUsernameButton;
	private JTextField editUsernameText;
	private JPasswordField editPasswordText;
	//private JButton showButton;
	//private JButton editGmailButton;
	private JButton backButton;
	//private JLabel CensoredLabel;
	private JButton logOutButton;
	private DatabaseManager db = new DatabaseManager();
	private int rowID;

	public Option(int rowID) {
		db.connectToDatabase();
		this.rowID = rowID;
		initialize();
		db.closeConnection();

	}

	private void initialize() {
		// frame
		setTitle("Options");
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		// Option Label
		optionLabel = new JLabel("Option");
		optionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionLabel.setBounds(115, 3, 46, 14);
		getContentPane().add(optionLabel, BorderLayout.CENTER);

		// Username Label

		usernameLabel = new JLabel("Username: ");
		usernameLabel.setBounds(10, 52, 70, 14);
		getContentPane().add(usernameLabel);

		// Password Label
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(10, 77, 76, 14);
		getContentPane().add(passwordLabel);

		// Gmail Label
		// gmailLabel = new JLabel("Gmail: ");
		// gmailLabel.setBounds(10, 105, 56, 14);
		// getContentPane().add(gmailLabel);

		// Delete Button
		btnNewButton = new JButton("Delete Account");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButtonActionPerformed(e);
			}
		});
		btnNewButton.setBounds(158, 232, 128, 23);
		getContentPane().add(btnNewButton);

		// Edit Username Button
		editUsernameButton = new JButton("Edit");
		editUsernameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsernameEditButtonActionPerformed(e);
			}
		});
		editUsernameButton.setBounds(168, 48, 63, 23);
		getContentPane().add(editUsernameButton);

		// Show Button
		/*
		showButton = new JButton("Show");
		showButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		showButton.setBounds(10, 105, 66, 23);
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show password from database

			}
		});
		**/
		//getContentPane().add(showButton);
		// Edit Gmail Button
		/*
		 * editGmailButton = new JButton("Edit"); editGmailButton.setBounds(151, 101,
		 * 63, 23); editGmailButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { //edit gmail Button } });
		 * getContentPane().add(editGmailButton);
		 */

		// backButton
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonActionPerformed(e);

			}
		});
		backButton.setBounds(215, 3, 75, 18);
		getContentPane().add(backButton);

		// Censored Label
		editPasswordText = new JPasswordField(db.password(this.rowID));
		editPasswordText.setBounds(80, 77, 85, 14);
		getContentPane().add(editPasswordText);

		JButton editUsernameButton_1 = new JButton("Edit");
		editUsernameButton_1.setBounds(168, 73, 63, 23);
		getContentPane().add(editUsernameButton_1);
		editUsernameButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordEditButtonActionPerformed(e);
			}
		});
		
		
		logOutButton = new JButton("LOG OUT");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOutButtonActionPerformed(e);
			}
		});
		logOutButton.setForeground(Color.BLUE);
		logOutButton.setBounds(10, 167, 89, 23);
		getContentPane().add(logOutButton);

		editUsernameText = new JTextField(db.username(this.rowID));
		editUsernameText.setBounds(80, 52, 85, 14);
		getContentPane().add(editUsernameText);
		setBounds(100, 100, 312, 305);
		setVisible(true);
	}
	public void deleteButtonActionPerformed(ActionEvent e) {
		db.connectToDatabase();
		
		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			if(rowID != 0) {
				try {
					db.deleteUserName(this.rowID);
				} catch (SQLIntegrityConstraintViolationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally
				{
					LoginPage loginPage = new LoginPage();
					loginPage.setVisible(true);
					this.dispose();
				}
			}
		}
	}

	public void UsernameEditButtonActionPerformed(ActionEvent e) throws HeadlessException {
		db.connectToDatabase();
		String newUsername = editUsernameText.getText();
		
		if(!newUsername.equals(db.username(this.rowID)))
		{
			try{
				db.updateUsername(this.rowID, newUsername);
				JOptionPane.showMessageDialog(null, "Username changed!");
			} catch(SQLIntegrityConstraintViolationException ex)
			{
				JOptionPane.showMessageDialog(null, "Username already taken");
			}

		}
	}
	
	public void PasswordEditButtonActionPerformed(ActionEvent e) {
		db.connectToDatabase();
		@SuppressWarnings("deprecation")
		String newPassword = editPasswordText.getText();
		if(!newPassword.equals(db.password(this.rowID)))
		{
			try {
				db.updatePassword(this.rowID, newPassword);
				JOptionPane.showMessageDialog(null, "Password changed!");
			} catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Password cannot be null");
			}

		}
	}
	
	public void logOutButtonActionPerformed(ActionEvent e) {
		LoginPage loginPage = new LoginPage();
		loginPage.setVisible(true);
		this.dispose();
	}

	public void backButtonActionPerformed(ActionEvent e) {
		UserData userData = new UserData(rowID);
		userData.setVisible(true);
		this.dispose();
	}

}