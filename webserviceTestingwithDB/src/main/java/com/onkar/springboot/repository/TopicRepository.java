package com.onkar.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.onkar.springboot.bean.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
