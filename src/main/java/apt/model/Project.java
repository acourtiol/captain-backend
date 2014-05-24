package apt.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Entity
@Table(name = "project", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_owner", "title"})})
public class Project extends Directory implements Serializable {
    private static final long serialVersionUID = -3979077272741003657L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_project", nullable = false)
    private Long idProject;

    @ManyToOne
    @JoinColumn(name = "id_owner", nullable = false)
    private Account owner;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
