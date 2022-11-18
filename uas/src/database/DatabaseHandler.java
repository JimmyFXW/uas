/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author hanschristian
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class DatabaseHandler {

    public Connection con;
    public Statement stat;
    public ResultSet resultSet;
    public java.sql.ResultSetMetaData resultSetMD;
    
    private String driver = "com.mysql.cj.jdbc.Driver";
//    private String url = "jdbc:mysql://localhost/db_test";
    private String url = "jdbc:mysql://localhost/db_uas_1121056";
    private String username = "root";
    private String password = "";

    public DatabaseHandler() {
        try {
            //Load JDBC Driver
            Class.forName(driver);
            //Buat Object Connection
            con = DriverManager.getConnection(url, username, password);
            stat = con.createStatement();
            System.out.println("Database connected");
        } catch (Exception ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
    }

	public ResultSet execQuery(String query) {
		try {
			resultSet = stat.executeQuery(query);
			resultSetMD = resultSet.getMetaData();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultSet;
	}

	public void executeUpdate(String query) {
		try {
			stat.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement prepareStatement(String query) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
	
}