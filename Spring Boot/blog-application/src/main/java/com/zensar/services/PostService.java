package com.zensar.services;

import java.util.List;

import com.zensar.dto.PageResponse;
import com.zensar.dto.PostDto;
import com.zensar.entity.Post;

public interface PostService {
	
	public PostDto createPost( PostDto postDto);
	
	public PageResponse getAllPosts(int pageNumber,int pageSize,String sortBy);
	
	public Post getPostByPostId(long id);
	
	public void deletePostById(long postId);
	
	public Post updatePost( int postId,  Post post);
	
	public List<Post> getAllPostsByTitle(String title);
	
	public List<Post> getAllPostsByTitleAndContent(String title,String content);

}
