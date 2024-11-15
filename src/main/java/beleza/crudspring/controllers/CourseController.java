package beleza.crudspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beleza.crudspring.domain.dto.CourseDto;
import beleza.crudspring.domain.model.Course;
import beleza.crudspring.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> listAllCourses() {
        return courseService.findAllCourses();
    }

    @PostMapping("/add")
    public ResponseEntity<Course> insertCourse(@RequestBody CourseDto courseDto) {
        courseService.insertCourse(courseDto);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
    		@PathVariable Long id, 
    		@RequestBody CourseDto courseToUpdate) {
    	courseService.updateCourse(id, courseToUpdate);
    	return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
