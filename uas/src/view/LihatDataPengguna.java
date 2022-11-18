package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.User;

/**
 *
 * @author user
 */
public class LihatDataPengguna extends JFrame{
	
	private DefaultTableModel tableModel;
	private JTable tableData;
	private Vector<Object> tableVector;
	static JFrame frame = new JFrame("Product Details");
    
    public void lihatDataPengguna() {
        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        
        //panel
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.GREEN);

        panelMenu.setBounds(0, 0, 1080, 75);
        panelMenu.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10,80,1050,190);
        frame.getContentPane().add(scrollPane);
        
        tableModel = new DefaultTableModel();	
        tableData = new JTable(tableModel) {
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        };
        scrollPane.setViewportView(tableData);
        
        loadData();
        
        //frame
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(panelMenu);

    }
    
    private void loadData() {
    	String headerTitle[] = {
    			"User ID", "Username", "Email", "Gender", "CategoryId", "User Followers", "User Password"
    	};
    	DefaultTableModel tableModel = new DefaultTableModel(headerTitle, 0);
    	Vector<User> tableUser = User.getAllUser();
    	for(User u : tableUser) {
    		Vector<Object> tableVector = new Vector<>();
    		tableVector.add(u.getUserId());
    		tableVector.add(u.getUserName());
    		tableVector.add(u.getUserEmail()); 
    		tableVector.add(u.getUserGender());
    		tableVector.add(u.getUserCategory().toString());
    		tableVector.add(u.getUserFollowers());
    		tableVector.add(u.getUserPassword());
    		tableModel.addRow(tableVector);
    	}
    	tableData.setModel(tableModel);
    }
}

