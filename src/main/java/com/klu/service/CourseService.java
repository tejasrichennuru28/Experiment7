package com.klu.service;

import com.klu.entity.Course;
import com.klu.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    // ADD course
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    // GET all courses
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    // GET course by ID
    public Optional<Course> getCourse(Long id) {
        return repo.findById(id);
    }

    // UPDATE course
    public Course updateCourse(Long id, Course course) {
        course.setCourseId(id);
        return repo.save(course);
    }

    // DELETE course
    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }

    // SEARCH by title
    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContaining(title);
    }
}