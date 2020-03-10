package com.nit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	//These fields map to the database table columns.
	@Id
	private String id; 
	private String name;
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	//no argument constructor .. so the object is easier to initialize.
	public Course() {
		
	}
	
	//argument based constructor..constructor takes these arguments and initialize the object.
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", ""); //creating a new instance of a Topic
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", topic=" + topic + "]";
	}

	
}
