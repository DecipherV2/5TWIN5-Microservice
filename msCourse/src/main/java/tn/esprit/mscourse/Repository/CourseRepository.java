package tn.esprit.mscourse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mscourse.Entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
