package com.niit.collaboration.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;
@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO{

	private static final Logger log = LoggerFactory.getLogger(TUserDAOImpl.class);

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	
	
	public FriendDAOImpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error(" Unable to connect to db");
			e.printStackTrace();
		}
	}

	
	private int getMaxId()
	{
		log.debug("->->Starting of the method getMaxId");
		
		String hql = "select max(id) from Friend";
		Query query = sessionFactory.openSession().createQuery(hql);
		int maxID;
		try {
			maxID = (Integer) query.uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}
		log.debug("Max id :"+maxID);
		return maxID;

	}

	@Transactional
	public boolean save(Friend friend) {

		try {
			log.debug("*********************88Previous id "+getMaxId());
			friend.setId(getMaxId()+1);
			log.debug("***********************generated id:"+getMaxId());
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	@Transactional
	public boolean update(Friend friend) {

		try {
			log.debug("inside update of daoimpl"+friend.getStatus());
			friend.setStatus(friend.getStatus());
			sessionFactory.openSession().update(friend);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	@Transactional
	public void delete(String userID, String friendID) {
		Friend friend = new Friend();
		friend.setFriendID(friendID);
		friend.setUserID(userID);
		sessionFactory.openSession().delete(friend);
	}

	@Transactional
	public List<Friend> getMyFriends(String userID) {
		String hql = "from Friend where userID=" + "'" + userID + "' and status ='"+ "A'";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Friend> list = (List<Friend>) query.list();
		return list;
	}
	
	@Transactional
	public List<Friend> getNewFriendRequests(String userID) {
		String hql = "from Friend where userID=" + "'" + userID + "' and status ='"+ "N'";
	    log.debug("hql: " + hql);

		Query query = sessionFactory.openSession().createQuery(hql);

		List<Friend> list = (List<Friend>) query.list();
	    log.debug("Freind list " + list);

		
		return list;

	}
	
	
	
	@Transactional
	public Friend get(String userID, String friendID) {
	    String hql = "from Friend where userID=" + "'" + userID + "' and friendID= '" + friendID + "'" ;
	    
	    log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		
		
		return (Friend) query.uniqueResult();
		

	}
	
	//We can use update method also.
	//isOnline need to set in controller and the ncal update
	
	
	
	/**
	 * Instead of writing the below two methods, you can use update method
	 */
	

	@Transactional
	public void setOnline(String userID) {
		log.debug("Starting of the metnod setOnline");
		String hql =" UPDATE Friend	SET isOnline = 'Y' where friendID='" +  userID + "'" ;
		  log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		query.executeUpdate();
		log.debug("Ending of the metnod setOnline");
		
	}
	
	@Transactional
	public void setOffLine(String userID) {
		log.debug("Starting of the metnod setOffLine");
		String hql =" UPDATE Friend	SET isOnline = 'N' where friendID='" +  userID + "'" ;
		  log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		query.executeUpdate();
		log.debug("Ending of the metnod setOffLine");
		
	}
	
	

}
