package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exception.CourseNotFoundException;
import com.model.Course;
import com.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/cms/find/{courseId}")
	public Course findCourse(@PathVariable("courseId") Integer courseId){
		Course course = courseService.searchCourse(courseId);
		if(course==null)
			throw new CourseNotFoundException("No such course id");
		return course;
	}
}