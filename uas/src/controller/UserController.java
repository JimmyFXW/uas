package controller;

import java.util.Vector;

import database.DatabaseHandler;
import model.User;

public class UserController {
	private DatabaseHandler con = new DatabaseHandler();
	private User user;
	private static UserController controller = null;
	
	public static UserController getInstance() {
		if(controller == null)
			controller = new UserController();
		return controller;
	}
	
	public void BarangController() {
		 user = new User(0, null, null, null, null, null, 0);
	}
	
	public Vector<User> getAllBarang(){
		return user.getAll();
	}
	
	public User getUserDetails(String username) {
		return user.getUserDetails(username);
	}
}