package com.zensar.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.PostDto;
import com.zensar.entity.Post;
import com.zensar.repository.PostRepository;
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	public PostDto createPost(PostDto postDto) {
		// convert dto into entity
		/*Post post=new Post();
		post.setPostId(postDto.getPostId());
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());*/
		
		Post post = modelMapper.map(postDto, Post.class);
		
		Post insertedPost = postRepository.save(post);
		
		// entity into dto
		
		/*PostDto dto=new PostDto();
		dto.setPostId(insertedPost.getPostId());
		dto.setTitle(insertedPost.getTitle());
		dto.setDescription(insertedPost.getDescription());
		dto.setContent(insertedPost.getContent());*/
		
		return modelMapper.map(insertedPost, PostDto.class);
		
	
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
	
	public List<Post> getAllPostsByTitle(String title) {
		return postRepository.retriveByTitle(title);
	}

	
	public List<Post> getAllPostsByTitleAndContent(String title,String content) {
		return postRepository.retriveByTitleAndContent(title, content);
	}

	


	
}
