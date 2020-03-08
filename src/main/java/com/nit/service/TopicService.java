package com.nit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.model.Topic;

@Service
public class TopicService {

	private List<Topic> topics = Arrays.asList(
			new Topic("spring", "spring framework", "spring framework Description"),
			new Topic("java", "core java", "core java Description"),
			new Topic("javascript", "javascript", "javascript Description")
		); 
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	//get particular topic ..its going to return one topic object
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
}
