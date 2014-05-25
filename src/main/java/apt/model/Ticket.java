package apt.model;

import apt.model.enums.TicketState;
import apt.model.enums.TicketType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ticket", nullable = false)
    private Long idTicket;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 2048)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketState state = TicketState.OPEN;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketType type;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_project", nullable = false)
    private Project project;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_creator", nullable = false)
    private Account creator;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_affectedTo")
    private Account affectedTo;

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
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

    public TicketState getState() {
        return state;
    }

    public void setState(TicketState state) {
        this.state = state;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account getAffectedTo() {
        return affectedTo;
    }

    public void setAffectedTo(Account affectedTo) {
        this.affectedTo = affectedTo;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", project=" + project +
                ", creator=" + creator +
                ", affectedTo=" + affectedTo +
                '}';
    }
}
