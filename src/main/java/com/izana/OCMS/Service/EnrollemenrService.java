package com.izana.OCMS.Service;

import com.izana.OCMS.DTO.EnrollementRequest;
import com.izana.OCMS.Entity.Course;
import com.izana.OCMS.Entity.Enrollement;
import com.izana.OCMS.Entity.User;
import com.izana.OCMS.Repository.CourseRepository;
import com.izana.OCMS.Repository.EnrollementRepository;
import com.izana.OCMS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollemenrService {
    @Autowired
    private EnrollementRepository enrollementRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    public Enrollement addEnrollement(EnrollementRequest request){
        User user = userRepository.getById(request.getStudentId());
        Course course = courseRepository.getById(request.getCourseId());

        if(user == null || course == null){
            throw new RuntimeException("User or Course not found");
        }
        Enrollement enrollement = new Enrollement();
        enrollement.setStudent(user);
        enrollement.setCourse(course);
        return enrollementRepository.save(enrollement);
    }

    public Enrollement getEnrollementById(Long id){
        return enrollementRepository.findById(id).get();
    }

    public List<Enrollement> getAllEnrollements(){
        return enrollementRepository.findAll();
    }
}
