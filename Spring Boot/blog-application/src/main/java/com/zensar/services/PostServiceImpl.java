package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Post;
import com.zensar.repository.PostRepository;
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	
	public Post getPostByPostId(long id) {
		return postRepository.findById(id).get();
	}

	
	public void deletePostById(long postId) {
		postRepository.deleteById(postId);
	}

	
	public Post updatePost( int postId,  Post post) {

		Post availablePost = getPostByPostId(postId);
		availablePost.setPostId(post.getPostId());
		availablePost.setTitle(post.getTitle());
		availablePost.setDescription(post.getDescription());
		availablePost.setContent(post.getContent());
		
		return postRepository.save(availablePost);
		
	}

	


	
}
