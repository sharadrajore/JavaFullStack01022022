package com.zensar.entity;

import lombok.Data;

@Data
public class Post {

	private long postId;
	private String title;
	private String description;
	private String content;

}
