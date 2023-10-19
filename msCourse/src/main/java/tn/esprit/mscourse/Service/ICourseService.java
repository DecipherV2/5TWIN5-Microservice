package tn.esprit.mscourse.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.mscourse.Entity.Course;

public interface ICourseService {
    public Long ajouterCourse(Course e);
    public Iterable<Course> retrieveAllCourse();

    public void deleteCourse(Long id);
    Course updateCourse(Course e);

    Course retrieveCourse (Long idCourse);
}

