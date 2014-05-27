package apt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Entity
@Table(name = "project", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_owner", "title"})})
public class Project implements Serializable {
    private static final long serialVersionUID = -3979077272741003657L;

    @Id
    @JsonProperty(value = "id_project")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_project", nullable = false)
    private Long idProject;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JsonProperty(value = "owner")
    @JoinColumn(name = "id_owner", nullable = false)
    private Account owner;

    @JsonProperty(value = "title")
    @Column(name = "title", nullable = false)
    private String title;

    @JsonProperty(value = "description")
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
