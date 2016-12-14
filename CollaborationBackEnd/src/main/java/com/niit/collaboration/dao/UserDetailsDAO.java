package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.UserDetails;

public interface UserDetailsDAO {

	public List<UserDetails> list();

	public UserDetails get(String id);

	public void saveOrUpdate(UserDetails userDetails);
	public void save(UserDetails userDetails);
	public void update(UserDetails userDetails);

	public void delete(String name);

	public UserDetails validate(String userid, String password);
	


}
