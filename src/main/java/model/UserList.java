package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserList {

	public static Collection<User> getUsers() throws ParseException{
		List<User> users = new ArrayList<User>();
		users.add(new User("admin", "adminPassword"));
		users.add(new User("user-test", "userPassword"));
		return users;
	}

}
