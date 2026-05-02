package com.izana.OCMS.Controller;

import com.izana.OCMS.DTO.CourseRequest;
import com.izana.OCMS.Entity.Course;
import com.izana.OCMS.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public Course addCourse(@RequestBody CourseRequest request){
        return courseService.addCourse(request);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping()
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/getAll/{instructorId}")
    public List<Course> getAllCoursesByInstructorId(@PathVariable Long instructorId){
        return  courseService.getAllCoursesByInstructorId(instructorId);
    }
}
