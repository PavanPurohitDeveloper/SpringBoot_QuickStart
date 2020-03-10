package com.nit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Course;
import com.nit.repository.CourseRespository;

@Service
public class CourseService {

	@Autowired
	private CourseRespository courseRespository;

	// Get All the Courses
	public List<Course> getAllCourses(String topicId) {
		List<Course> coursesList = new ArrayList<>();
		courseRespository.findByTopicId(topicId)// It gets iterable
				.forEach(coursesList::add); // for each of the elements found, and put that element into topicsList..use
											// method reference

		return coursesList;
	}

	// call to database and get the particular topic Id
	public Course getCourse(String id) {
		return courseRespository.findById(id).orElse(new Course());
	}

	// Creating a new Course //save the Course into database table..
	public void addCourse(Course course) {
		courseRespository.save(course);
	}

	// update the Topic based on the Topic Id
	public void updateCourse(Course course) {
		courseRespository.save(course); // It can do both Add and Update operations. I need to pass an Topic instance
	}

	// Delete the Course
	public void deleteCourse(String id) {
		courseRespository.deleteById(id);
	}
}
