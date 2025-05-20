package ibrah.webg5.pae.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ibrah.webg5.pae.model.Course;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@SpringBootTest
public class CourseTest {
    
    @Autowired
    private BeanValidationUtil<Course> validator;

    /* Cas valide */
    @Test
    public void loginValid() {
        Course user = new Course("fr", "français",4 , null);
        validator.assertIsValid(user);
    }


    @Test
    public void testNotSizeId(){
        Course course = new Course("1", "title", 2, null);
        validator.assertHasError(course, "id", Size.class);
    }

    @Test
    public void testNotSizeTitle(){
        Course course = new Course("cours1", "t", 2, null);
        validator.assertHasError(course, "title", Size.class);
    }

    @Test
    public void testNotMaxCredits(){
        Course course = new Course("cours1", "title", 12, null);
        validator.assertHasError(course, "credits", Max.class);
    }

    // @Test
    // public void testNotEmptyId(){
    //     Course course = new Course("", "title", 2, null);
    //     validator.assertHasError(course, "id", NotEmpty.class);
    //     validator.assertHasError(course, "id", Size.class);
    // }

    // @Test
    // public void nameValid() {
    //     MyUser user = new MyUser("ValidLogin", "Name");
    //     validator.assertIsValid(user);
    // }

    // /* Cas d'erreurs  */
    // // Size annotation not respected
    // @Test
    // public void loginSizeLessThan6Error() {
    //     MyUser user = new MyUser("Login", "Name");
    //     validator.assertHasError(user, "login", Size.class);
    // }

    // // NotBlank annotation not respected
    // @Test
    // public void nameBlankError() {
    //     MyUser user = new MyUser("ValidLogin", "");
    //     validator.assertHasError(user, "name", NotBlank.class);
    // }
}

