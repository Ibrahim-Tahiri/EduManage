package ibrah.webg5.pae.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ibrah.webg5.pae.model.Course;
import ibrah.webg5.pae.repository.CourseRepository;

@SpringBootTest
public class CourseServiceTest {
    
    @Autowired
    private CourseService courseService; // le service usant le Repository de test

    @MockBean
    private CourseRepository courseRepository; // le Repository de test

    @Test
    public void getUserById() {
        String id = "MAT1";
        Course course = new Course("MAT1", "Mathematiques II", 3, null);

        // Mockito.when(courseRepository.findById(id).get()).thenReturn(course); // règle imposée qui suppose que le Repository fonctionne bien

        Mockito.when(courseRepository.findById(id)).thenReturn(Optional.of(course));
        Course found = courseService.getCourseById(id); // règle appliquée ici par le service dans la méthode "getUserByName" qui call userRepository.findByName(String name)


        assertEquals(found.getId(), id); // Le but est juste de voir que le service est correctement implémentée ! Qu'il fait appel aux bonnes méthodes du Repository !
    }
}
