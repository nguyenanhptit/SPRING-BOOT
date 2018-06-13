package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.User;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mysql.cj.api.xdevapi.Result;

public class UserDAOImpl implements UserDAO {
	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	public static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	private final static int SIZE_OF_PAGE = 2;

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
	}

	@Override
	public List<User> listUser(Integer group) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		try {
			if (group == null || group < 0) {
				Query query = session.createQuery("from User order by age desc");
				return query.getResultList();
			} else {
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Restrictions.eq("groupId", group));
				return new ArrayList<User>(criteria.list());
			}
		} finally {
			session.close();
		}
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		try {
			return session.get(User.class, username);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		String hql = "delete from User where username like :name";
		org.hibernate.query.Query query = session.createQuery(hql);
		query.setParameter("name", username);
		int result = query.executeUpdate();
		logger.info("row affected " + result + "\n\n");
	}

	@Override
	public List<User> listOlder() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.gt("age", 50));
		return (List<User>) cr.list();
	}

	@Override
	public int averageAge() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.setProjection(Projections.avg("age"));
		List avgAge = cr.list();
		return ((Double) avgAge.get(0)).intValue();
	}

	@Override
	public List<User> page(int page) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getObject().openSession();
		Criteria cr = session.createCriteria(User.class);
		int start = (page - 1) * SIZE_OF_PAGE;
		cr.setFirstResult(start);
		cr.setMaxResults(SIZE_OF_PAGE);

		return (List<User>) cr.list();
	}

}
