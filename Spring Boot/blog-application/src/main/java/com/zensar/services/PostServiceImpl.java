package com.zensar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zensar.dto.PageResponse;
import com.zensar.dto.PostDto;
import com.zensar.entity.Post;
import com.zensar.exceptions.PostIdNotAvailableException;
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

	
	public PageResponse getAllPosts(int pageNumber,int pageSize,String sortBy) {
		
		Pageable pageable=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).descending());
		
		Page<Post> posts = postRepository.findAll(pageable);
		
		List<Post> postList = posts.getContent();
		
		List<PostDto> listOfPostDto=new ArrayList<>();
		
		for(Post post:postList) {
			
			PostDto dto = modelMapper.map(post,PostDto.class);
			listOfPostDto.add(dto);
			
		}
		
		PageResponse pageResponse=new PageResponse();
		pageResponse.setContent(listOfPostDto);
		pageResponse.setPageNumber(posts.getNumber());
		pageResponse.setPageSize(posts.getSize());
		pageResponse.setTotalElements(posts.getTotalElements());
		pageResponse.setTotalPages(posts.getTotalPages());
		pageResponse.setLast(posts.isLast());
		
		return pageResponse;
	}

	
	public Post getPostByPostId(long id) {
		Optional<Post> optPost = postRepository.findById(id);
		
		if(optPost.isPresent()) {
			Post post=optPost.get();
			return post;
		}
		
		throw new PostIdNotAvailableException(" "+id); 
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
