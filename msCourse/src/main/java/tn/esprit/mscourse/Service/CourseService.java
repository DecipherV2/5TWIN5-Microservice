package tn.esprit.mscourse.Service;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import tn.esprit.mscourse.Entity.Course;
import tn.esprit.mscourse.Repository.CourseRepository;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import io.micrometer.core.ipc.http.HttpSender.Response;




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

    @Autowired
    ServletContext context;
    @Override
    public ResponseEntity<Response> add(MultipartFile file, String Course) throws JsonParseException, JsonMappingException, Exception
    {

        System.out.println("Ok .............");
        Course c = new ObjectMapper().readValue(Course, Course.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir success.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        c.setImage(newFileName);

        Course art = courseRepository.save(c);



        if (art != null)
        {
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }



    }






}
