package edu.hanoi.jazz.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.hanoi.jazz.dao.model.User;

@Component("userDAO")
public interface UserDAO {
	public void insert(User user);

	public List<User> listUser(Integer group);

	public User getUserByUsername(String username);
	
	public void deleteUser(String username);
	
	public List<User> listOlder();
	
	public int averageAge();
	
	public List<User> page(int page);
}
