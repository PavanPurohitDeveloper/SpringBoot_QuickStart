package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Topic;
import com.nit.service.TopicService;

@RestController
public class TopicController {

	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {

		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		
		return topicService.getTopic(id);
	}
	
	/**
	 * If you want to create a new resource (Ex: Topic) , you have to make a POST request..
	 * get the POST body, converted into Topic instance, and add that to the List  in the TopicService..
	 * pick this instance from the @RequestBody
	 * @RequestBody -- tells spring MVC that, your request failover will contain JSON representation of this Topic instance and you are asking to take that RequestBody and converted into a Topic Instance..
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	
}
