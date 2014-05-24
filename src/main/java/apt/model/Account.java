package apt.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
@DiscriminatorColumn(name="type", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("account")
public class Account implements Serializable {
    private static final long serialVersionUID = -6070188485677954082L;

    @Id
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
