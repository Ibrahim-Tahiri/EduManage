package ibrah.webg5.pae.business;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibrah.webg5.pae.model.Course;
import ibrah.webg5.pae.model.Student;
import ibrah.webg5.pae.repository.CourseDB;
import ibrah.webg5.pae.repository.StudentDB;

//bussiness est la facade,
@Service//bean de type service
public class PAE {
@Autowired
private CourseDB courseDB;
@Autowired
private StudentDB studentDB;

    public List<Course> getCourses(){//bonne pratique de ne mettre que l'interface
        // List<Course> course = new ArrayList<Course>();
        // Course c1 = new Course("INT1", "INTRODUCTIONS", 10);
        // Course c2 = new Course("MAT1", "MATHEMATIQUES 2", 3);
        // Course c3 = new Course("CAI1", "ANGLAIS 1", 2);
        // Course c4 = new Course("DEV1", "DEBELOPPEMENT 1", 10);
        // Course c5 = new Course("DEV2", "DEVELOPPEMENT 2", 10);
        // Course c6 = new Course("WEBG2", "DEVELOPPEMENT WEB 1", 5);

        // course.add(c1);
        // course.add(c2);
        // course.add(c3);
        // course.add(c4);
        // course.add(c5);
        // course.add(c6);
        List<Course> course = new ArrayList<Course>();
        course = (List<Course>) courseDB.findAll();
        return course;

    }
    public List<Student> getStudents(){
        List<Student> student = new ArrayList<Student>();
        student = (List<Student>) studentDB.findAll();
        return student;
    }

    public Course getCourse(String id) {
        Optional<Course> c = courseDB.findById(id);
        return c.get();
    }
    public Student getStudent(long studentId) {
        Optional<Student> c = studentDB.findById(studentId);
        return c.get();
    }
    
}
