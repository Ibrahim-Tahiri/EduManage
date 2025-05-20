package ibrah.webg5.pae.jdbc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Authority {
    @Id
    private long id;
    private String username;
    private String authority;
}
