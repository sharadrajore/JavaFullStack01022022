package com.zensar.dto;

import lombok.Data;

@Data
public class PostDto {

	private long postId;
	private String title;
	private String description;
	private String content;

}
