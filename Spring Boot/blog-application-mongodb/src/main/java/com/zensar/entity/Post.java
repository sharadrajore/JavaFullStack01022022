package com.zensar.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection ="blogCollection" )
public class Post {

	@Id
	private long postId;
	private String title;
	private String description;
	private String content;

}
