package edu.hanoi.jazz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.model.Group;


@Repository
public class GroupDAOImpl implements GroupDAO {
	@Autowired
	private final static Logger LOGGER = Logger.getLogger(GroupDAOImpl.class);
	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	public LocalSessionFactoryBean getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	@Override
	@Transactional
	public void insert(Group group) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		try {
			session.save(group);
			session.flush();
			LOGGER.info("Save group " + group.getName());
		} finally {
			session.close();
		}

	}

	@Override
	public List<Group> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		Query<Group> query = session.createQuery("form Group");
		try {
			return (List<Group>) query.list();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		Group group = session.get(Group.class, id);
		if (group == null)
			return;
		session.delete(group);
		session.flush();
		LOGGER.info("delete group" + group.getName() + "successful");
		session.close();
	}

	@Override
	public void update(Group group) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		group = (Group) session.merge(group);

		session.save(group);
		session.flush();
		LOGGER.info("update group" + group.getName() + "successful");
		session.close();
	}

	@Override
	public Group getGroupById(int id) {
		Session session = sessionFactory.getObject().openSession();
		try {
			Group group = session.get(Group.class, id);
			return group;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Group> listGroup(String pattern) {
		Session session = sessionFactory.getObject().openSession();
		try {
			if (pattern == null || pattern.length() < 1) {
				Query<Group> query = session.createQuery("from Group");
				return (List<Group>) query.list();
			}
			Criteria criteria = session.createCriteria(Group.class);
			criteria.add(Restrictions.like("name", "%" + pattern + "%", MatchMode.ANYWHERE));

			return new ArrayList<>(criteria.list());
		} finally {
			session.close();
		}
	}

}
