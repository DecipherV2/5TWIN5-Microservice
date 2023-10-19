package tn.esprit.mscourse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mscourse.Entity.Course;
import tn.esprit.mscourse.Service.ICourseService;

@Controller
@RestController
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    ICourseService icourseService;

    @GetMapping("/")
    public Iterable<Course>  GetAllCourse(){
        return icourseService.retrieveAllCourse();
    }

    @PostMapping("/addCourse")
    @ResponseBody
    public void addCourse(@RequestBody Course course) {
        icourseService.ajouterCourse(course);
    }

    @GetMapping("/retrieve-course/{course-id}")
    public Course retrieveCourse(@PathVariable("course-id") Long courseId) {
        return icourseService.retrieveCourse(courseId);
    }

    @PutMapping("/updateCourse")
    @ResponseBody
    public void updateCourse(@RequestBody Course course) {
        icourseService.updateCourse(course );
    }

    @DeleteMapping("/deleteCourse/{course-id}")
    @ResponseBody
    public void deleteCourse(@PathVariable("course-id") Long courseId ) {
        icourseService.deleteCourse(courseId);
    }
}


