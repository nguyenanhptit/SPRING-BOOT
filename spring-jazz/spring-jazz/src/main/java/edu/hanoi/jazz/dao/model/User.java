package edu.hanoi.jazz.dao.model;

public class User implements Comparable<User>{
	private String username;
	private String password;
	private String email;
	private int age;
	private int groupId;
	private Group group;
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(String username, String password, String email, int age, int groupId, Group group) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.groupId = groupId;
		this.group = group;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	@Override
	public int compareTo(User other) {
		// TODO Auto-generated method stub
		return age - other.age;
	}
}