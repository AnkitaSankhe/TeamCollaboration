package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;
public interface BlogDAO

{
	public List<Blog> list();
	
    public void saveOrUpdate(Blog blog);
    
    public void delete(int id);
    public void save(Blog blogDetails);
    public Blog get(int id);
	
}
