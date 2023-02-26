package com.masai.servies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Post;

import com.masai.exceptions.PostNotFoundException;

import com.masai.repos.PostRepo;

@Service
public class PostSerImpl implements PostService{
	
	@Autowired
	private PostRepo postRepo;

	@Override
	public Post savePost(Post post) {
		postRepo.save(post);
		return post;
		
	}

	@Override
	public Post editPost(Post post, Integer postid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getallPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer id) throws PostNotFoundException {
		Optional<Post> post = postRepo.findById(id);

		if (post.isPresent()) {

			return post.get();

		} else {
			throw new PostNotFoundException("Plant does not exist with this PlantId");
		}
	}

	@Override
	public Post DeletePost(Integer postid) throws PostNotFoundException {
		Optional<Post> post = postRepo.findById(postid);

		if (post.isPresent()) {
			Post popt = post.get();
			postRepo.deleteById(postid);
			;
			return popt;
		} else {
			throw new PostNotFoundException("No plant present with this PlantId");
		}
	}

}
