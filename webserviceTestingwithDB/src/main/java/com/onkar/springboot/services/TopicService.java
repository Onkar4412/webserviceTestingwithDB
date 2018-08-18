package com.onkar.springboot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onkar.springboot.bean.Topic;
import com.onkar.springboot.repository.TopicRepository;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Java", "Java 8", "Java topics"),
			new Topic("Spring", "Spring Boot", "Spring boot topics"),
			new Topic("Hibernate", "Hibernate ORM", "Hibernate topics")
			));

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
	
		ArrayList<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);;
		return topics;
	}


	public Topic getTopic(String id) {
		
		//topicRepository.findById(id);
		return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
	}


	public void addTopictoDatabase(Topic topic) {
		
		topicRepository.save(topic);
		//topics.add(topic);
	}
	
	public void deleteTopicfromDatabase(String id) {
		
		topics.removeIf(topicId -> topicId.getId().equals(id));
	}

	public void updateTopicfromDatabase(String id, Topic topic) {
		
		topics.forEach(tpc -> {
			if(tpc.getId().equals(id)) {
				topics.set(topics.indexOf(tpc), topic);
			}	
		});
	}
}
