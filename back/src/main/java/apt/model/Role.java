package apt.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jeremie.drouet
 * @date 15/05/14
 */
@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_owner", "label"})})
public class Role implements Serializable {
    private static final long serialVersionUID = -1687033939683830396L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role", nullable = false)
    private Long idRole;

    @ManyToOne
    @JoinColumn(name = "id_owner", nullable = true)
    private Project owner;

    @Column(name = "label", nullable = false)
    private String label;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Project getOwner() {
        return owner;
    }

    public void setOwner(Project owner) {
        this.owner = owner;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
