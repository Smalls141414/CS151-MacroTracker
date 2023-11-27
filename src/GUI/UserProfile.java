package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;

import SQLite.DatabaseManager;

public class UserProfile extends JFrame {

	JPanel panel;
	JLabel userLabel;
	JButton optionButton;
	JPanel friendsPanel;
	JLabel friendsLabel;
	JList list;
	JPanel panel2;
	private DatabaseManager db = new DatabaseManager();
	private int rowID;
	private JButton logOutButton;

	public UserProfile(int rowID) {
		db.connectToDatabase();
		this.rowID = rowID;
		initialize();
		db.closeConnection();
	}

	private void initialize() {

		// frame
		setResizable(false);
		getContentPane().setBackground(new Color(64, 224, 208));
		setBounds(100, 100, 520, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Base Panel
		panel = new JPanel();
		panel.setBounds(104, 20, 144, 50);
		getContentPane().add(panel);
		panel.setLayout(null);

		// UserLabel
		userLabel = new JLabel("[USER]");
		userLabel.setBounds(57, 11, 46, 14);
		panel.add(userLabel);

		// Button Option
		optionButton = new JButton("Option");
		optionButton.setBackground(new Color(128, 128, 128));
		optionButton.setBounds(405, 20, 89, 23);
		optionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionButtonActionPerformed(e);
			}
		});
		getContentPane().add(optionButton);

		// Friends Panel
		friendsPanel = new JPanel();
		friendsPanel.setBackground(new Color(248,248,255));
		friendsPanel.setBounds(374, 81, 120, 238);
		getContentPane().add(friendsPanel);
		friendsPanel.setLayout(null);

		// Friends Label
		friendsLabel = new JLabel("Friends List");
		friendsLabel.setBounds(10, 11, 80, 14);
		friendsPanel.add(friendsLabel);

		// Friends List
		list = new JList();
		list.setBackground(new Color(248,248,255));
		list.setBounds(10, 36, 100, 199);
		friendsPanel.add(list);

		// Big Panel
		panel2 = new JPanel();
		panel2.setBackground(new Color(248, 248, 255));
		panel2.setBounds(32, 81, 315, 238);
		getContentPane().add(panel2);

		JButton UserDataButton = new JButton("User Macro Data");
		UserDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDataButtonActionPerformed(e);
			}
		});
		panel2.setLayout(null);
		UserDataButton.setBounds(31, 31, 113, 23);
		panel2.add(UserDataButton);

		JButton MacroGraphButton = new JButton("Macro Graph");
		MacroGraphButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				macroGraphButtonActionPerformed(e);
			}
		});
		MacroGraphButton.setBounds(181, 31, 113, 23);
		panel2.add(MacroGraphButton);

		logOutButton = new JButton("LOG OUT");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOutButtonActionPerformed(e);
		}
	});
		logOutButton.setForeground(new Color(255, 0, 0));
		logOutButton.setBackground(new Color(255, 255, 255));
		logOutButton.setBounds(0, 215, 77, 23);
		panel2.add(logOutButton);

	}
	public void logOutButtonActionPerformed(ActionEvent e) {
		LoginPage loginPage = new LoginPage();
		loginPage.setVisible(true);
		this.dispose();
	}

	public void optionButtonActionPerformed(ActionEvent e) {
		Option option = new Option(rowID);
		option.setVisible(true);
		this.dispose();
	}
	public void userDataButtonActionPerformed(ActionEvent e) {
		UserData userData = new UserData(rowID);
		userData.setVisible(true);
		this.dispose();
	}
	
	public void macroGraphButtonActionPerformed(ActionEvent e) {
		//Need to add connection to macro graph here
	}
//	private String getName() {
//		String sql = "";
//		Connection connection = new Connection();
//		PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		
//		ResultSet resultSet;
//		return "";
//	}
}
