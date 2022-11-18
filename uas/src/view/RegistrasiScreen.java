package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import model.CategoryUser;
import model.User;

public class RegistrasiScreen extends JFrame implements ActionListener{
	JFrame frame;
	JTextField username;
	JPasswordField password;
	JTextField email;
	
	JRadioButton pria;
	JRadioButton wanita;
	ButtonGroup kelamin;
	
	JComboBox UserCategory;
	
	JButton registrasi;
	JButton back;
	
	public void registrasiScreen() {
		frame = new JFrame();
		JPanel contentPane;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Menu Registrasi");
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
		
		password = new JPasswordField();
		password.setBounds(150, 125, 100, 20);
		password.addActionListener(this);
		contentPane.add(password);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(20, 150, 100, 15);
		contentPane.add(emailLabel);
		
		email = new JTextField();
		email.setBounds(150, 150, 100, 20);
		email.addActionListener(this);
		contentPane.add(email);
		

		JLabel jenisKelamin = new JLabel("Jenis Kelamin");
		jenisKelamin.setBounds(20, 175, 100, 14);
		contentPane.add(jenisKelamin);
		
		pria = new JRadioButton("Pria");
		pria.setBounds(150, 170, 50, 25);
		pria.addActionListener(this);
		contentPane.add(pria);
		
		wanita = new JRadioButton("Wanita");
		wanita.setBounds(200, 170, 75, 25);
		wanita.addActionListener(this);
		contentPane.add(wanita);
		
		kelamin = new ButtonGroup();
		kelamin.add(pria);
		kelamin.add(wanita);
		
		JLabel CategoryUserLabel  = new JLabel("User Category");
		CategoryUserLabel.setBounds(20, 200, 100, 14);
		contentPane.add(CategoryUserLabel);
		
		String[] categories = {"Private Account","Creator Account","Business Account"};    
		UserCategory = new JComboBox(categories);
		UserCategory.setBounds(150, 200, 100, 20);
		UserCategory.addActionListener(this);
		contentPane.add(UserCategory);
		
		registrasi = new JButton("Registrasi");
		registrasi.setBounds(170, 225, 70, 20);
		registrasi.addActionListener(this);
		contentPane.add(registrasi);
		
		back = new JButton("Back");
		back.setBounds(170, 250, 70, 20);
		back.addActionListener(this);
		contentPane.add(back);
		
		frame.add(contentPane);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registrasi) {
			if(username.getText().isBlank() || String.valueOf(password.getPassword()).isBlank() || email.getText().isBlank() || getRadioValue(kelamin).isBlank() || UserCategory.getSelectedItem().toString().isBlank()) {
				JOptionPane.showMessageDialog(null, "Tolong isi semua field!",
					      "Hey!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				//(int userId, String userName, String userEmail, String userGender, String userPassword,
				//CategoryUser userCategory, int userFollowers)
				User user = new User(username.getText(), String.valueOf(password.getPassword()), );
			}
		}
		else if(e.getSource() == back) {
			frame.setVisible(false);
		}
	}
	String getRadioValue(ButtonGroup group) {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

}