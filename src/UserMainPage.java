package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import SQLite.DatabaseManager;

public class UserMainPage extends JFrame {

	private JPanel contentPane;
	private DatabaseManager db = new DatabaseManager();
	private int rowID;

	public UserMainPage(int rowID) {
		db.connectToDatabase();
		this.rowID = rowID;
		initalize();
		db.closeConnection();

	}

	private void initalize() {
		setTitle("Macro Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setForeground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 281, 239);
		contentPane.add(panel);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(335, 11, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(335, 81, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public void userDataButtonActionPerformed(ActionEvent e) {
		
	}
}
