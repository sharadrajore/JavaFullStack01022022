package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")

/*@NamedQueries(value = { @NamedQuery(name = "Post.retriveByTitle", query = "FROM Post p where p.title=?1"),
		@NamedQuery(name = "Post.retriveByTitleAndContent", query = "from Post p where p.title=?1 and p.content=?2")
})*/


/*@NamedNativeQueries(value = { @NamedNativeQuery(name = "Post.retriveByTitle", query = "select * from posts where title=?1",resultClass = Post.class),
		@NamedNativeQuery(name = "Post.retriveByTitleAndContent", query = "select * from posts where title=?1 and content=?2",resultClass = Post.class)
		})*/


public class Post {

	@Id
	private long postId;
	private String title;
	private String description;
	private String content;
	

}
