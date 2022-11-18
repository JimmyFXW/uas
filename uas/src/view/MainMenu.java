package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame implements ActionListener{
	JButton login;
	JButton registrasi;
	JButton lihatData;
	
	public void mainMenu() {
		JFrame frame = new JFrame();
		JPanel contentPane;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 900, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		login = new JButton("Login");
		login.setBounds(350, 200, 150, 40);
		login.addActionListener(this);
		contentPane.add(login);
		
		registrasi = new JButton("Registrasi");
		registrasi.setBounds(350, 300, 150, 40);
		registrasi.addActionListener(this);
		contentPane.add(registrasi);
		
		lihatData = new JButton("Lihat Data");
		lihatData.setBounds(350, 400, 150, 40);
		lihatData.addActionListener(this);
		contentPane.add(lihatData);
		
		frame.add(contentPane);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			new LoginScreen().loginScreen();
		}
		if(e.getSource() == registrasi) {
			new RegistrasiScreen().registrasiScreen();
		}
		if(e.getSource() == lihatData) {
			
		}
	}
}
