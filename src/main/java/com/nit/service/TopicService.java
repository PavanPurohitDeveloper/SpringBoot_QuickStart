package com.nit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.model.Topic;

@Service
public class TopicService {

	//contains a List of Topics
	//Created a List of hard coded values using Arrays.asList... Arrays.asList method creates an Immutable list
	//In order to edit the List we converted to new ArrayList<>( )...
	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("spring", "spring framework", "spring framework Description"),
			new Topic("java", "core java", "core java Description"),
			new Topic("javascript", "javascript", "javascript Description")
		)); 
	
	//Get All the Topics
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	//get particular topic ..its going to return one topic object
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	//Creating a new Topic
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	
}
