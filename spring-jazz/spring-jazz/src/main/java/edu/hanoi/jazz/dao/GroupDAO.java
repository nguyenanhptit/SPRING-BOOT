package edu.hanoi.jazz.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.hanoi.jazz.dao.model.Group;

@Component("groupDAO")
public interface GroupDAO {
	public void insert(Group group);

	public List<Group> list();

	public void delete(int id);

	public void update(Group group);

	public Group getGroupById(int id);

	public List<Group> listGroup(String pattern);
	
	
}
