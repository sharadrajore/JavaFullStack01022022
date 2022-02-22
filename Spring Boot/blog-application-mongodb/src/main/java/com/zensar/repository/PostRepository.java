package com.zensar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zensar.entity.Post;

public interface PostRepository extends MongoRepository<Post, Long> {

}
