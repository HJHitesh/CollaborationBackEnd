package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {
	
	public Blog getBlogById(String id);
	
	public Blog getBlogByName(String name);
	
	public boolean saveOrupdate(Blog blog);
	
	public boolean deleteById(String id);
	
	public boolean deletebyBlog(Blog blog);
	
	public boolean deleteByName(String name);
	
	public List<Blog> list();
	
	

}
