package ibrah.webg5.pae.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.annotation.Annotation;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;


@Component
public class BeanValidationUtil<T> {
    @Autowired
    private Validator validator;

    /**
     * Teste qu'une entité est bien valide.
     * Le test qui appelle cette méthode échoue si l'entité n'est pas valide.
     * @param entity l'entité a tester.
     */
    public void assertIsValid(T entity) {
        assertTrue(validator.validate(entity).isEmpty()); // vérifie que l'instance d'une Entity donnée en argument respecte bien ses annotations.
    }

    /**
     * Teste qu'une entité possède une violation de contrainte.
     * Le test qui appelle cette méthode réussit si l'entité viole
     * la contrainte indiquée par les paramètres et uniquement celle-là.
     * @param entity l'entité à tester.
     * @param invalidField l'attribut qui n'est pas valide.
     * @param violatedConstraint l'annotation de l'attribut qui n'est pas respectée.
     */
    public void assertHasError(T entity, String invalidField, Class<? extends Annotation> violatedConstraint) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity); // valide ou non l'instance d'une Entity donnée en argument
        assertEquals(1, violations.size()); // compare le nombre d'annotations qui n'ont pas été respectée
        ConstraintViolation<T> violation = violations.iterator().next(); // step avant comparaison ?
        assertEquals(invalidField, violation.getPropertyPath().toString()); // compare le champs qui a eu une erreur
        assertEquals(violatedConstraint, violation.getConstraintDescriptor().getAnnotation().annotationType()); // compare l'annotation qui n'a pas été respectée
    }
}
