package ibrah.webg5.pae.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToMany;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    
    @Id
    @GeneratedValue(generator = "my_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "my_gen", sequenceName = "my_seq", allocationSize = 50, initialValue = 50)
    private long matricule; 

    @NotBlank(message = "Le nom ne doit pas être vide")@Size(min=2,max=20,message = "le titre est entre 2 et 20 caractères")
    private String nom;


    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Enumerated(EnumType.ORDINAL)
    private Section section;

    @JsonBackReference
    @ManyToMany(mappedBy = "students")//ici je peux pas modification juste lire
    private Collection<Course> courses;


    @Override
public String toString() {
    return "Student(matricule=" + matricule + ", nom=" + nom + ", gender=" + gender + ", section=" + section + ", numCourses=" + courses.size() + ")";
}

}
