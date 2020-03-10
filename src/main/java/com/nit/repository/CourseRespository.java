package com.nit.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.nit.model.Course;

//perform the CRUD operations
public interface CourseRespository extends CrudRepository<Course, String>{
		
	//get All the courses by Name.. It should starts with word - find
	//public List<Course> findByName(String name);
	//public List<Course> findByDescription(String desc);
	
	//Looking the field in that Object (Topic object)
	public List<Course> findByTopicId(String topicId);
	
}
