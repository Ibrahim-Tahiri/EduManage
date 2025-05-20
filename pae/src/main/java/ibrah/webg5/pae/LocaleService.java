package ibrah.webg5.pae;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Permet de changer de langue en restant sur la même page
 */
@ControllerAdvice
public class LocaleService {//changer parametre langue sans changer la page
    @ModelAttribute
    public LocaleService localeService() {
        return new LocaleService();
    }

    public String changeTo(String lang) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replaceQueryParam("lang", lang)
                .toUriString();
    }
}
