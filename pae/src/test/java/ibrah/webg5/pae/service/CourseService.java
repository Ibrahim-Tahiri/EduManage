package ibrah.webg5.pae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibrah.webg5.pae.jdbc.MyUser;
import ibrah.webg5.pae.model.Course;
import ibrah.webg5.pae.repository.CourseRepository;



@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course getCourseById(String id) {
        return courseRepository.findById(id).get();
    }
}
