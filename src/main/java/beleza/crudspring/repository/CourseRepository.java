package beleza.crudspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import beleza.crudspring.domain.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public Optional<Course> findByName(String name);
}
