package apt.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = -6070188485677954082L;

    @Id
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uid", unique = true, nullable = false)
    private String uid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
