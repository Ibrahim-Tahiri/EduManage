package ibrah.webg5.pae.jdbc;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyUser {
    @Id
    private String username;
    private String password;
    private Boolean enabled;
}
