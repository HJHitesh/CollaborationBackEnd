package com.niit.collaboration.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

import oracle.net.aso.r;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	private static Logger log = LoggerFactory.getLogger("UserDAOImpl");
	
	
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	public boolean saveOrupdate(User user) {
		
	log.debug("Starting of the Save Method");
	
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			log.info("id"+user.getId());
			log.info("name"+user.getName());
			log.info("address"+user.getPassword());
			log.info("id"+user.getRole());
			log.info("id"+user.getAddress());
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.debug("Starting of the Save Method");
			return false;
		}
	}

	/*public boolean update(User user) {
		log.debug("Starting of update method");
		sessionFactory.getCurrentSession().
		return false;
	}*/

	public List<User> list() {
		log.debug("Starting and Ending of the ****LIST Method****");
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	public User get(String id) {
		log.debug("Starting  of the ****get Method of USER module ****");
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		log.debug(" Ending of the ****get Method of USER module ****");
		return user;
	}

	public boolean isValidate(String id, String password) {
		log.debug("Starting of the **** isValidate Method of USER module ****");
		
		Query<r> query = sessionFactory.getCurrentSession().createQuery("from User where id=? and password=?");
		
		query.setString(0, id);
		
		query.setString(1, password);
		
		if(query.uniqueResult()==null){
			
			log.debug("Ending of the **** isValidate Method of USER module ****");
			return false;
		}
		else
		{
			return true;
		}
		
	}

}
