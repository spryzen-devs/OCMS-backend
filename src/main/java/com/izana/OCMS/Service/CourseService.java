package com.izana.OCMS.Service;

import com.izana.OCMS.DTO.CourseRequest;
import com.izana.OCMS.Entity.Course;
import com.izana.OCMS.Repository.CourseRepository;
import com.izana.OCMS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    public Course addCourse(CourseRequest request){
        Course curr = courseRepository.findByTitle(request.getTitle());
        if(curr != null){
            throw new RuntimeException("Course already exists");
        }
        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setInstructor(userRepository.findById(request.getInstructorId()).get());
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public List<Course> getAllCoursesByInstructorId(Long instructorId){
        return courseRepository.findByInstructorId(instructorId);
    }
}
