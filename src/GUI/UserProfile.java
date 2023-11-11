package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;

public class UserProfile extends JFrame{

	JPanel panel;
	JLabel userLabel;
	JButton optionButton;
	JPanel friendsPanel;
	JLabel friendsLabel;
	JList list;
	JPanel panel2;
	JScrollBar scrollBar;

	public static void main(String[] args) {
		new UserProfile();

	}

	public UserProfile() {
		initialize();
	}

	private void initialize() {
		
		//frame
		getContentPane().setBackground(new Color(64, 224, 208));
		setBounds(100, 100, 724, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		//Base Panel
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(207, 20, 286, 50);
		getContentPane().add(panel);
		panel.setLayout(null);

		//UserLabel
		userLabel = new JLabel("[USER]");
		userLabel.setBounds(120, 5, 46, 14);
		panel.add(userLabel);

		//Button Option
		optionButton = new JButton("Option");
		optionButton.setBackground(new Color(128, 128, 128));
		optionButton.setBounds(569, 20, 89, 23);
		optionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Option();
			}
		});
		getContentPane().add(optionButton);
		
		//Friends Panel
		friendsPanel = new JPanel();
		friendsPanel.setBackground(new Color(0, 128, 128));
		friendsPanel.setBounds(575, 81, 100, 313);
		getContentPane().add(friendsPanel);
		friendsPanel.setLayout(null);

		//Friends Label
		friendsLabel = new JLabel("Friends List");
		friendsLabel.setBounds(10, 11, 80, 14);
		friendsPanel.add(friendsLabel);
		
		//Friends List
		list = new JList();
		list.setBackground(new Color(0, 128, 128));
		list.setBounds(10, 36, 80, 266);
		friendsPanel.add(list);

		//Big Panel
		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 139, 139));
		panel2.setBounds(32, 81, 505, 313);
		getContentPane().add(panel2);

		scrollBar = new JScrollBar();
		scrollBar.setBounds(691, 0, 17, 461);
		getContentPane().add(scrollBar);

		setVisible(true);
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
