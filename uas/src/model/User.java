package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import database.DatabaseHandler;

public class User {
	private int userId;
	private String userName;
	private String userEmail;
	private String userGender;
	private String userPassword;	
	private CategoryUser userCategory;
	private int userFollowers;
	
	
	private static DatabaseHandler con = new DatabaseHandler();
	
	public User() {
		
	}
	public User(String userName, String userEmail, String userGender, String userPassword,
			CategoryUser userCategory, int userFollowers) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userPassword = userPassword;
		this.userCategory = userCategory;
		this.userFollowers = userFollowers;
	}

	private static User map(ResultSet rs) {
		int userId;
		String userName;
		String userEmail;
		String userGender;
		int userFollowers;
		String userPassword;
		
		CategoryUser userCategory;
		int userCategoryId;
		String userCategoryName;

		try {
			userId = rs.getInt("userid");
			userName = rs.getString("username");
			userEmail = rs.getString("useremail");
			userGender = rs.getString("usergender");
			userCategoryId = rs.getInt("categoryid");
			userFollowers = rs.getInt("userfollowers");
			userPassword = rs.getString("userpassword");
			userCategoryName = rs.getString("categoryname");
			userCategory = new CategoryUser(userCategoryId, userCategoryName);
			
			return new User(userName, userEmail, userGender, userPassword,
					userCategory, userFollowers);
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public User getUserDetails(String username) {
		String query = String.format("SELECT * FROM user "
				+ "INNER JOIN categoryuser "
				+ "ON user.categoryid = categoryuser.categoryid "
				+ "WHERE username = ?");
		PreparedStatement preparedStatement = con.prepareStatement(query);
		con.resultSet = null;
		try {
			preparedStatement.setString(1, username);
			con.resultSet = preparedStatement.executeQuery();
			if(con.resultSet.next()) {
				User user = map(con.resultSet);
				return user;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void insertUserDetails(User user) {
		String query = String.format("INSERT INTO `user` (`username`, `useremail`, `usergender`, `categoryid`, `userfollowers`, `userpassword`) "
				+ "VALUES (?, ?, ?, ?, ?, ?)");
		PreparedStatement preparedStatement = con.prepareStatement(query);
		con.resultSet = null;
		try {
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserEmail());
			preparedStatement.setString(3, user.getUserGender());
			preparedStatement.setInt(4, user.userCategory.getCategoryId());
			preparedStatement.setInt(5, user.getUserFollowers());
			preparedStatement.setString(6, user.getUserPassword());
			con.resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public static Vector<User> getAllUser() {
		con.resultSet = con.execQuery("SELECT * FROM barang");
		Vector<User> userVector = new Vector<>();
		try {
			while (con.resultSet.next()) {
				User user = map(con.resultSet);
				userVector.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userVector;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public CategoryUser getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(CategoryUser userCategory) {
		this.userCategory = userCategory;
	}

	public int getUserFollowers() {
		return userFollowers;
	}

	public void setUserFollowers(int userFollowers) {
		this.userFollowers = userFollowers;
	}

	public DatabaseHandler getCon() {
		return con;
	}

	public void setCon(DatabaseHandler con) {
		this.con = con;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userGender="
				+ userGender + ", userPassword=" + userPassword + ", userCategory=" + userCategory + ", userFollowers="
				+ userFollowers + ", con=" + con + "]";
	}
	
}