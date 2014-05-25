package apt.model;

import apt.model.enums.TicketState;
import apt.model.enums.TicketType;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_ticket",nullable = false)
    private Long idTicket;

    @Column(name="title",nullable = false)
    String title;

    @Column(name="description")
    String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    TicketState state = TicketState.OPEN;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    TicketType type;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    Project project;

    @ManyToOne
    @JoinColumn(name = "id_creator", nullable = false)
    Account creator;

    @ManyToOne
    @JoinColumn(name = "id_affectedTo")
    Account affectedTo;

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

}
