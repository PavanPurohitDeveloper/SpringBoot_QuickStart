package com.nit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nit.model.Topic;

//perform the CRUD operations
public interface TopicRespository extends CrudRepository<Topic, String>{
		
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic t)
	//deleteTopic(String id)

	
}
