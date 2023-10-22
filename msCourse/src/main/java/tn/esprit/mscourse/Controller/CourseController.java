package tn.esprit.mscourse.Controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.mscourse.Entity.Course;
import tn.esprit.mscourse.Service.ICourseService;

@Controller
@RestController
@RequestMapping("/Course")
@CrossOrigin(origins = "*")
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

    @PutMapping("/updateCourse/{course-id}")
    @ResponseBody
    public void updateCourse(@RequestBody Course course) {
        icourseService.updateCourse(course );
    }

    @DeleteMapping("/deleteCourse/{course-id}")
    @ResponseBody
    public void deleteCourse(@PathVariable("course-id") Long courseId ) {
        icourseService.deleteCourse(courseId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<HttpSender.Response> addArticle(@RequestPart("file") MultipartFile file, @RequestParam("Course") String c)throws JsonParseException, JsonMappingException, Exception {
        return icourseService.add(file,c);
    }

}


