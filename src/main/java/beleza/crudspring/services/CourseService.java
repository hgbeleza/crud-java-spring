package beleza.crudspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beleza.crudspring.domain.model.Course;
import beleza.crudspring.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAllCourses() {
        List<Course> courses = courseRepository.findAll();

        if(courses.isEmpty()) {
            throw new RuntimeException("Courses not found");
        }

        return courses;
    }
}
