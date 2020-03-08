package com.nit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Topic;
import com.nit.repository.TopicRespository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRespository topicRespository;

	//contains a List of Topics
	//Created a List of hard coded values using Arrays.asList... Arrays.asList creates an Immutable list
	//In order to edit the List we converted to new ArrayList<>( )...
	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("spring", "spring framework", "spring framework Description"),
			new Topic("java", "core java", "core java Description"),
			new Topic("javascript", "javascript", "javascript Description")
		)); 
	
	//Get All the Topics
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topicsList = new ArrayList<Topic>();
		topicRespository.findAll() //It gets iterable
		.forEach(topicsList :: add); //for each of the elements found, and put that element into topicsList..use method reference
		
		return topicsList;
	}
	
	//get particular topic ..its going to return one topic object
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	//Creating a new Topic //save the topic into database table..
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRespository.save(topic);
	}

	//update the Topic based on the Topic Id
	public void updateTopic(String id, Topic topic) {
		//Loop the topics
		for(int i=0; i < topics.size(); i++) {
			Topic t = topics.get(i); // for each topic in that List compare the Id
			if(t.getId().equals(id)) { //If it matches, send the updated topic.
				topics.set(i, topic);
				return;
			}
		}
	}
	
	//Delete the topic
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
