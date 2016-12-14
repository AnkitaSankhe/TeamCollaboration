package com.niit.collaboration.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

@RestController
public class BlogController {
	@Autowired
	private BlogDAO blogDAO;
	
	
	@Autowired
	private Blog blog;

	@Autowired
	ServletContext req;
	
	
	@GetMapping("/BlogDetails/")
	public ResponseEntity<List<Blog>> listAllUserDetails(){
		List<Blog> blogDetails = blogDAO.list();
		System.out.println(blogDetails);
		if (blogDetails.isEmpty()){
			
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<Blog>>(blogDetails, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/Blog/{username}")
	public ResponseEntity<Blog> getBlog(@ModelAttribute("username") int id){
		
		Blog Blog = blogDAO.get(id);
		if (Blog == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Blog>(Blog, HttpStatus.OK);
	}
	
	
	@PostMapping("/BlogSave/")
	public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder)
	{
	System.out.println("@@@@@@@@@@@@@---------------->>>In Blog Detail");
	System.out.println(blog.getTitle()+"  "+ blog.getDescription());
		if(blogDAO.get(blog.getId())!= null)
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	
		
//		Blog.setStatus("Pending");
		blogDAO.save(blog);
//		
//		String subject = "Registration Successfull !";
//		String emailText1= "Dear ";
//		String emailText2= ". We have successfully received your request to be a part of HUB. You have requested to register as ";
//		String emailText3= ". We will shortly notify you about your request approval. Thank You";
//		System.out.println("To: " + Blog.getEmail());
//		SimpleMailMessage email = new SimpleMailMessage();
//		email.setTo(Blog.getEmail());
//		email.setSubject(subject);
//		email.setText(emailText1+Blog.getName()+emailText2+Blog.getRole()+emailText3);
//		
//		mailSender.send(email);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Blog/{id}").buildAndExpand(blog.getTitle()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
		
	}
	@PutMapping("/Blog/{username}")
	public ResponseEntity<Blog> updateBlog(@ModelAttribute("username") int id, @RequestBody Blog blog){
		
		blog = blogDAO.get(id);
		if (blog == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			
		}
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	
	@PostMapping("/admin/delete/{user}")
	public ResponseEntity<Blog> deleteBlog(@ModelAttribute("user") int id)
	{
		System.out.println(id);
		System.out.println("inside BlogController delete Blog");
		Blog Blog = blogDAO.get(id);
		if (Blog == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
			
		}
		blogDAO.delete(id);
		return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);

	}
	
//	@PostMapping ("/UserValidate/")
//public ResponseEntity<Blog> checkUser(@RequestBody Blog Blog){
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@in login method");
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ Received UserId as: "+Blog.getUserId()+" & password as: "+Blog.getPassword());
//		Blog = BlogDAO.validate(Blog.getUserId(), Blog.getPassword());
//		if (Blog==null){
//			Blog = new Blog();
//			Blog.setErrorMessage("Invalid Credentials!");
//			return new ResponseEntity<Blog>(Blog,HttpStatus.OK);
//	}	else if(Blog.getStatus().equalsIgnoreCase("Pending")){
//		Blog = new Blog();
//		Blog.setErrorMessage("Your Registration Request is not yet Approved.");
//		return new ResponseEntity<Blog>(Blog,HttpStatus.OK);
//	}
//	else if(Blog.getStatus().equalsIgnoreCase("Rejected")){
//		Blog = new Blog();
//		Blog.setErrorMessage("Your Request for Registration has been Rejected!");
//		return new ResponseEntity<Blog>(Blog,HttpStatus.OK);
//	}
//	else
//		return new ResponseEntity<Blog>(Blog, HttpStatus.OK);
//
//	}
}
