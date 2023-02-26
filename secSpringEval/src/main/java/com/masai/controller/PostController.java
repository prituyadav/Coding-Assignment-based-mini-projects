package com.masai.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Post;

import com.masai.exceptions.PostNotFoundException;


import com.masai.repos.PostRepo;
import com.masai.servies.PostService;


@RestController
public class PostController {
	
	@Autowired
	private PostRepo re;
	
	@Autowired
	private Post p;
	
	@Autowired
	private PostService sp;
	
	
	@PostMapping("/posts")
	   public ResponseEntity<String> savePostHandler(@org.springframework.web.bind.annotation.RequestBody Post p) throws PostNotFoundException {

		  sp.savePost(p);
		  
		  String ms="post success.....";
		  return new ResponseEntity<String>(ms, HttpStatus.OK);
			
			
		}
		
	
	@DeleteMapping("delete/posts")
	   public ResponseEntity<String> deletePosttHandler(@org.springframework.web.bind.annotation.RequestBody Integer id) throws PostNotFoundException {

		  sp.DeletePost(id);
		  
		  String ms="post delete success.....";
		  return new ResponseEntity<String>(ms, HttpStatus.OK);
			
			
		}
		
	
	@PostMapping("/posts")
	   public ResponseEntity<String> editPostHandler(@org.springframework.web.bind.annotation.RequestBody Post p, Integer id) throws PostNotFoundException {

		  sp.editPost(p, id);
		  
		  String ms="post edit success.....";
		  return new ResponseEntity<String>(ms, HttpStatus.OK);
			
			
		}
		
		
		
		

	}
	
	
	
	


