package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Post;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

	// http://localhost:8080/api/posts/test/{name} - PathVariable

	// http://localhost:8080/api/posts/test?name=Ram - RequestParam

	@GetMapping("/test")
	public String sayHello(@RequestParam("name") String name) {
		return "Hello " + name;
	}

	// C -Created R -Read all post/{postId } U- updated D-delete

	private List<Post> posts = new ArrayList<>();

	// http://localhost:8080/api/posts -> POST

	// @RequestMapping(value = "/api/posts",method = RequestMethod.POST)
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		posts.add(post);
		return new ResponseEntity<Post>(post, HttpStatus.CREATED);
	}

	// @RequestMapping(value = "/api/posts",method = RequestMethod.GET)
	@GetMapping()
	public List<Post> getAllPosts() {
		return posts;
	}

	// http://localhost:8080/api/post/100
	// @RequestMapping(value = "/api/posts/{postId}",method = RequestMethod.GET)
	@GetMapping(value = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Post getPostByPostId(@PathVariable("postId") int id) {
		for (Post post : posts) {
			if (post.getPostId() == id)
				return post;
		}
		return null;
	}

	@DeleteMapping("/{postId}")
	public boolean deletePostById(@PathVariable("postId") int postId) {

		for (Post post : posts) {
			if (post.getPostId() == postId)
				return posts.remove(post);
		}

		return false;
	}

	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable("postId") int postId, @RequestBody Post post) {

		Post availablePost = getPostByPostId(postId);
		availablePost.setTitle(post.getTitle());
		availablePost.setDescription(post.getDescription());
		availablePost.setContent(post.getContent());

		return availablePost;
	}

}
