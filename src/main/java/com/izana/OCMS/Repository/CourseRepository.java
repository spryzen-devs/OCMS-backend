package com.izana.OCMS.Repository;

import com.izana.OCMS.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByTitle(String title);

    List<Course> findByInstructorId(Long instructorId);
}
