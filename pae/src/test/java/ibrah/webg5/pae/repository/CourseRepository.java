package ibrah.webg5.pae.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ibrah.webg5.pae.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
     public Optional<Course> findById(String id);
     
     @Query("select c FROM Course c WHERE length(c.title)>15")
     public ArrayList<Course> findByLongLogin();
     }
    
