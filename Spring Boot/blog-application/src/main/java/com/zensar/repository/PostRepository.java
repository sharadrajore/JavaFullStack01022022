package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
	
	//List<Post> queryByTitle(String title);
	
	//List<Post> findByTitleAndContent(String title,String content);
	
	@Query(value = "select * from posts where title=:title",nativeQuery =true )
	List<Post> retriveByTitle(String title);
	
	@Query(value="select * from posts where title=:mytitle and content=:mycontent",nativeQuery = true)
	List<Post> retriveByTitleAndContent(@Param("mytitle")String title,@Param("mycontent")String content);
	
	
}
