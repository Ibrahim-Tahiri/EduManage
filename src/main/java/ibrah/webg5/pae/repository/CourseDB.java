package ibrah.webg5.pae.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ibrah.webg5.pae.model.Course;

public interface CourseDB extends CrudRepository<Course,String>{
    List<Course> findByCreditsGreaterThanEqual(int credits);

    Course findByTitleContaining(String title);
    

}
