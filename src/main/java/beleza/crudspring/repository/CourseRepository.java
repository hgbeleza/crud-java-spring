package beleza.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import beleza.crudspring.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByName(String name);
}
