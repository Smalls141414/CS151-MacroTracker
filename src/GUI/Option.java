package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import SQLite.DatabaseManager;

@SuppressWarnings("serial")
class Option extends JFrame {
	private JLabel optionLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel gmailLabel;
	private JLabel privacyLabel;
	private JButton btnNewButton;
	private JButton editUsernameButton;
	private JButton showButton;
	private JButton editGmailButton;
	private JButton listButton;
	private JLabel CensoredLabel;
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
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		// Option Label
		optionLabel = new JLabel("Option");
		optionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionLabel.setBounds(109, 3, 46, 14);
		getContentPane().add(optionLabel, BorderLayout.CENTER);

		// Username Label
		usernameLabel = new JLabel("Username: ");
		usernameLabel.setBounds(10, 52, 66, 14);
		getContentPane().add(usernameLabel);

		// Password Label
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(10, 77, 76, 14);
		getContentPane().add(passwordLabel);

		// Gmail Label
		//gmailLabel = new JLabel("Gmail: ");
		//gmailLabel.setBounds(10, 105, 56, 14);
		//getContentPane().add(gmailLabel);

		// Privacy Label
		privacyLabel = new JLabel("Privacy ");
		privacyLabel.setBounds(10, 150, 56, 14);
		getContentPane().add(privacyLabel);

		// Delete Button
		btnNewButton = new JButton("Delete Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Delete from database
			}
		});
		btnNewButton.setBounds(10, 247, 113, 23);
		getContentPane().add(btnNewButton);

		// Edit Username Button
		editUsernameButton = new JButton("Edit");
		editUsernameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//edit username from database
			}
		});
		editUsernameButton.setBounds(151, 48, 63, 23);
		getContentPane().add(editUsernameButton);

		// Show Button
		showButton = new JButton("Show");
		showButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		showButton.setBounds(122, 77, 46, 15);
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Show password from database 
				
			}
		});
		getContentPane().add(showButton);

		// Edit Gmail Button
		/*
		editGmailButton = new JButton("Edit");
		editGmailButton.setBounds(151, 101, 63, 23);
		editGmailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//edit gmail Button
			}
		});
		getContentPane().add(editGmailButton);
		*/

		// List Button
		listButton = new JButton("List");
		listButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		listButton.setBounds(151, 150, 56, 18);
		getContentPane().add(listButton);

		// Censored Label
		CensoredLabel = new JLabel("****");
		CensoredLabel.setBounds(91, 80, 46, 14);
		getContentPane().add(CensoredLabel);
		setBounds(100, 100, 312, 305);
		setVisible(true);
	}

}