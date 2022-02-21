package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Post {

	@Id
	private long postId;
	private String title;
	private String description;
	private String content;

}
