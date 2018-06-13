package edu.hanoi.jazz.dao.model;

import java.util.List;
import java.util.SortedSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SortNatural;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "hn_group")
public class Group {

	private int id;
	private SortedSet<User> users;
	// @Column(name = "id" , unique= true ,nullable= false)
	private String name;

	// @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch =
	// FetchType.EAGER)
	// @SortComparator(UserNameComparator.class)
	//
	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "group")
	@SortNatural
	public SortedSet<User> getUsers() {
		return users;
	}

	public void setUsers(SortedSet<User> users) {
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Group(String name, int id) {

		this.name = name;
		this.id = id;
	}

	public Group() {
		super();
	}

	public SortedSet<User> getUser() {
		return users;
	}

}
