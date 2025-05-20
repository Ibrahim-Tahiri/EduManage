package ibrah.webg5.pae.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data // une annotation constru tout argument, annotation constructeur sans argument
      // car besoin des 2, cest une annotation lombok
public class Course {
    @Id
    @NotBlank(message = "L'identifiant ne doit pas être vide")
    @Size(min = 2, max = 6, message = "l'identifiant est composé de 2 ou 3 caractères")
    private String id;

    @NotBlank(message = "Le titre ne doit pas être vide")
    @Size(min = 2, max = 20, message = "le titre est entre 5 et 20 caractères")
    private String title;

    @Positive(message = "Le nombre de crédits doit être strictement supérieur à 0")
    @Min(value = 1, message = "le nombre de crédits doit être entre 1 et 10 compris")
    @Max(value = 10, message = "le nombre de crédits doit être entre 1 et 10 compris")
    private int credits;

    // @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    @JsonManagedReference
    private Collection<Student> students;//pas de mapped by = , propriétaire de la raletation

    /**
     * Contruction NO ENTITY
     */
    public Course(String id, String title, int credits){
        this.id = id;
        this.title = title;
        this.credits = credits;
    }


    @Override
    public String toString() {
        
        return "Course(id=" + id + ", title=" + title + ", credits=" + credits + ", numStudents=" //+ students.size()
                + ")";
    }

}
