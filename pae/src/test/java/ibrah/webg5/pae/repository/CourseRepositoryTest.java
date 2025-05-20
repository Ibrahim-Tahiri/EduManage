
package ibrah.webg5.pae.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ibrah.webg5.pae.model.Course;
import ibrah.webg5.pae.model.Student;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findByName() {
        Course course = new Course("id","français",4, null);
        courseRepository.save(course);
        Course found = courseRepository.findById(course.getId()).get();
        assertEquals(course, found);
    }



    // @Test
    // public void findByLongId() {
    //     Course course1 = new Course("id", "title", 8, null);
    //     Course course2 = new Course("id", "letitlelongdelonggg", 8, null);
    //     courseRepository.save(course1);
    //     courseRepository.save(course2);
    //     ArrayList<Course> found = courseRepository.findByLongLogin();
    //     assertEquals(1, found.size());
    //     assertEquals(course2, found.get(0));
    // }

    // @Test
    // public void findByLongId() {
    //     Course user1 = new Course("ValidLogin","MCD");
    //     Course user2 = new Course("VeryLongLogin","MCD");
    //     userRepository.save(user1);
    //     userRepository.save(user2);
    //     List<Course> found = userRepository.findByLongLogin();
    //     assertEquals(1, found.size());
    //     assertEquals(user2, found.get(0));
    // }
}
