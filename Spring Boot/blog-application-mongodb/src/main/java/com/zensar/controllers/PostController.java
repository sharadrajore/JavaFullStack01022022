package com.zensar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Post;
import com.zensar.services.PostService;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

	// http://localhost:8080/api/posts/test/{name} - PathVariable

	// http://localhost:8080/api/posts/test?name=Ram - RequestParam

	@Autowired
	private PostService postService;

	// @RequestMapping(value = "/api/posts",method = RequestMethod.POST)
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		Post post2 = postService.createPost(post);
		return new ResponseEntity<Post>(post2, HttpStatus.CREATED);
	}

	// @RequestMapping(value = "/api/posts",method = RequestMethod.GET)
	@GetMapping()
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	// http://localhost:8080/api/post/100
	// @RequestMapping(value = "/api/posts/{postId}",method = RequestMethod.GET)
	@GetMapping(value = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Post getPostByPostId(@PathVariable("postId") int id) {
		return postService.getPostByPostId(id);
	}

	@DeleteMapping("/{postId}")
	public void deletePostById(@PathVariable("postId") int postId) {
		postService.deletePostById(postId);

	}

	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable("postId") int postId, @RequestBody Post post) {
		return postService.updatePost(postId, post);
	}

}
