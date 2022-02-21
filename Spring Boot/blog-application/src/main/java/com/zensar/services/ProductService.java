package com.zensar.services;

import java.util.List;

import com.zensar.entity.Post;

public interface ProductService {
	
	public Post createPost( Post post);
	
	public List<Post> getAllPosts();
	
	public Post getPostByPostId(int id);
	
	public boolean deletePostById(int postId);
	
	public Post updatePost( int postId,  Post post);

}
