package model;

import java.text.ParseException;

public class User {
	
	public static int countUser = 0;
	private int id;
	private String username;
	private String password;
	
	public User(String username, String password) throws ParseException {
		countUser++;
		this.id = countUser;
		this.setUsername(username);
		this.setPassword(password);
		
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
