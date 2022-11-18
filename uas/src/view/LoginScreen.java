package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import model.User;

public class LoginScreen extends JFrame implements ActionListener{
	JFrame frame;
	JTextField username;
	JTextField password;
	JButton login;
	JButton back;
	
	public void loginScreen() {
		frame = new JFrame();
		JPanel contentPane;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Aplikasi NoIdea");
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setBounds(70, 25, 365, 55);
		contentPane.add(title);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(20, 100, 100, 15);
		contentPane.add(usernameLabel);
		
		username = new JTextField();
		username.setBounds(150, 100, 100, 20);
		username.addActionListener(this);
		contentPane.add(username);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 125, 100, 15);
		contentPane.add(passwordLabel);
		
		password = new JTextField();
		password.setBounds(150, 125, 100, 20);
		password.addActionListener(this);
		contentPane.add(password);
		
		login = new JButton("Login");
		login.setBounds(170, 170, 70, 20);
		login.addActionListener(this);
		contentPane.add(login);
		
		back = new JButton("Back");
		back.setBounds(170, 200, 70, 20);
		back.addActionListener(this);
		contentPane.add(back);
		
		frame.add(contentPane);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			String usernameQuery = username.getText();
			User searchedUser = new User();
			searchedUser = searchedUser.getUserDetails(usernameQuery);
			
			String passwordInput = username.getText();
			if(searchedUser.getUserPassword().equals(passwordInput)) {
				new LihatDataPengguna().lihatDataPengguna();;
			}
			else {
				JOptionPane.showMessageDialog(null, "Password salah, wrong etc!",
					      "Hey!", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == back) {
			frame.setVisible(false);
		}
	}

}
