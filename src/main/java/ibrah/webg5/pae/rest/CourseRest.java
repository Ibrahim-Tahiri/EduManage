package ibrah.webg5.pae.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ibrah.webg5.pae.model.Course;

import ibrah.webg5.pae.business.PAE;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class CourseRest {
    @Autowired PAE pae;
//retourner une liste de cours

    @GetMapping("courses")
public List<Course> listCourses(){
    return pae.getCourses();

}


}
