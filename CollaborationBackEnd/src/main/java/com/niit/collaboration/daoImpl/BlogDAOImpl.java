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

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	private static Logger log = LoggerFactory.getLogger("BlogDAOImpl");

	
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrupdate(Blog blog) {
		log.debug("Starting of the Save Method");

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			log.info("id" + blog.getId());
			log.info("name" + blog.getTitle());
			log.info("address" + blog.getUserID());
			log.info("id" + blog.getDescription());
			log.info("id" + blog.getStatus());
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.debug("Starting of the Save Method");
			return false;
		}

	}

	public boolean deleteById(String id) {

		try {
			sessionFactory.getCurrentSession().delete(getBlogById(id));
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean deleteByName(String name) {

		try {
			sessionFactory.getCurrentSession().delete(getBlogByName(name));
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}

	}

	public boolean deletebyBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public List<Blog> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
		
		
		
	}

	public Blog getBlogById(String id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Blog where id=?");

		return (Blog) query.setString(0, id).uniqueResult();
	}

	public Blog getBlogByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Blog where name=?");

		return (Blog) query.setString(0, name).uniqueResult();

	}

	

}
