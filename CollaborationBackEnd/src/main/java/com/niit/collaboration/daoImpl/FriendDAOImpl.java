package com.niit.collaboration.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {

	private static Logger log = LoggerFactory.getLogger("FriendDAOImpl");

	
	private SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrupdate(Friend friend) {
		log.debug("Starting of the Save Method");

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.debug("Starting of the Save Method");
			return false;
		}

	}

	public boolean deleteById(String id) {

		try {
			sessionFactory.getCurrentSession().delete(getFriendById(id));
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}

	}
	
	/*public boolean deleteByName(String name) {

		try {
			sessionFactory.getCurrentSession().delete(getFriendByName(name));
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}

	}*/

	/*public boolean deletebyFriend(Friend Friend) {
		try {
			sessionFactory.getCurrentSession().delete(Friend);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}*/

	public List<Friend> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from Friend").list();
		
		
		
	}

	public Friend getFriendById(String id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Friend where id=?");

		return (Friend) query.setString(0, id).uniqueResult();
	}

	public Friend getFriendByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Friend where name=?");

		return (Friend) query.setString(0, name).uniqueResult();

	}

	

}
