package com.masai.servies;

import java.util.List;

import com.masai.entity.Post;
import com.masai.exceptions.PostNotFoundException;

public interface PostService {
	public Post savePost(Post post);
	
	public Post DeletePost(Integer postid) throws PostNotFoundException;
	
	public Post editPost(Post post, Integer postid) throws PostNotFoundException;
	
	public List<Post> getallPost();
	
	
	public Post getPostById(Integer id) throws PostNotFoundException;
	
}
