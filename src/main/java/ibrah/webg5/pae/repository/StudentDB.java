package ibrah.webg5.pae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ibrah.webg5.pae.model.Student;

public interface StudentDB extends CrudRepository<Student,Long>{
    // List<Course> findByCreditsGreaterThanEqual(int credits);

    // Course findByTitleContaining(String title);

    @Query("SELECT s.nom FROM Student s")
    List<String> findNameStudent();

    @Query("SELECT s.nom, s.matricule FROM Student s")
    List<Object> findAllNameAndIdStudent();

    //3. des noms des étudiants et du nombre total d’ects dans leur programme ;
    @Query("SELECT SUM(c.credits), s.nom FROM Student s JOIN s.courses c GROUP BY s.nom")
    List<Object[]> findAllNameAndEtcStudent();

    @Query("SELECT s FROM Student s JOIN s.courses c GROUP BY s HAVING SUM(c.credits) > :creditsValue")
    List<Student> findByTotalCreditsGreaterThan(int creditsValue);

    List<Student> findByNomContainingIgnoreCase(String filter);

}
