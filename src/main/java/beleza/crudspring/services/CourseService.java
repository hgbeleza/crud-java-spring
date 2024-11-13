package beleza.crudspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beleza.crudspring.domain.dto.CourseDto;
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
    
    public Course insertCourse(CourseDto courseDto) {
        Optional<Course> isExist = courseRepository.findByName(courseDto.name());

        if(isExist.isPresent()) {
            throw new RuntimeException("Name already exists");
        }

        Course newCourse = new Course();
        newCourse.setName(courseDto.name());
        newCourse.setCategory(courseDto.category());

        return courseRepository.save(newCourse);
    }
}
