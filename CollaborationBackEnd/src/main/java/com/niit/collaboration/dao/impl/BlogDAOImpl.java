package com.niit.collaboration.dao.impl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	Blog userDetails;
	
	public BlogDAOImpl()
	{
		
	}
	
	public BlogDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Blog blog) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	@Transactional
	public void delete(int blogId) 
	{
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogToDelete);
	}

	@Transactional
	public Blog get(int blogId) 
	{
		String hql = "from Blog where id=" + "'" + blogId + "'";
		// from user where id = '101'
		@SuppressWarnings({ })
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings({ "unchecked" })
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}

	public List<Blog> list() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Blog> blogDetailsList = session.createQuery("from Blog").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Blog Details");
		return blogDetailsList;
	}

	@Transactional
	public void save(Blog blogDetails) 
	{
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- before .save query fired");
		System.out.println("in save"+blogDetails.getDescription());
		sessionFactory.getCurrentSession().save(blogDetails);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save query fired");
	}


}
