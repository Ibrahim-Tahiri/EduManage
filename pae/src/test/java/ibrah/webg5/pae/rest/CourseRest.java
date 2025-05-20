package ibrah.webg5.pae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibrah.webg5.pae.model.Course;
import ibrah.webg5.pae.service.CourseService;





@RestController
@RequestMapping("/api")
public class CourseRest {

    @Autowired
    private CourseService userService;

    @GetMapping("/courses/{id}")
    public Course getUserById(@PathVariable("id") String id) {
        return userService.getCourseById(id);
    }
}
