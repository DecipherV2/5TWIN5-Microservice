package tn.esprit.mscourse.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.mscourse.Entity.Course;
import tn.esprit.mscourse.Repository.CourseRepository;

@Service
@Slf4j
public  class CourseService implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;


    public Long ajouterCourse(Course e) {
        courseRepository.save(e);
        log.info("Ajouter Equipe");
        return e.getIdCourse();
    }
    @Override
    public Iterable<Course> retrieveAllCourse() {return courseRepository.findAll();}

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);}

    @Override
    public Course updateCourse(Course e) {return courseRepository.save(e);}

    @Override
    public Course retrieveCourse(Long idCourse) {
        return courseRepository.findById(idCourse).get();
    }









}
