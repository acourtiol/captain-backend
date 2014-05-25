package apt.model;

import apt.model.enums.TicketState;
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

    @OneToMany(mappedBy = "project")
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private Set<Ticket> tickets;

    @Formula(value = "(SELECT count(*) FROM mail m WHERE m.id_project = id_project)")
    private Integer nbMails;

    @Formula(value = "(SELECT count(*) FROM ticket t WHERE t.state = 'OPEN' and t.id_project = id_project)")
    private Integer ticketsOpened;

    @Formula(value = "(SELECT count(*) FROM ticket t WHERE t.state = 'CLOSED' and t.id_project = id_project)")
    private Integer ticketsClosed;

    @Formula(value = "(SELECT count(*) FROM ticket t WHERE t.state = 'IN_PROGRESS' and t.id_project = id_project)")
    private Integer ticketsInProgress;

    @Formula(value = "(SELECT count(*) FROM ticket t WHERE t.state = 'RESOLVED' and t.id_project = id_project)")
    private Integer ticketsResolved;


//    @Formula(value = "(SELECT t.state, count(*) FROM Ticket t group by t.state")
//    Map<String, Integer> countByState;

    // and t.id_project = this_.id_project

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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @JsonProperty
    public Map<String, Integer> getStateCount() {
        Map<String, Integer> stateCount = new HashMap<String, Integer>();
        if (null != this.getTickets()) {
            for (Ticket t : this.getTickets()) {
                Integer num = 1;
                if (stateCount.containsKey(t.getState().toString())) {
                    num = stateCount.get(t.getState().toString()) + 1;
                }
                stateCount.put(t.getState().toString(), num);
            }
        }

        return stateCount;
    }


    public Integer getTicketsOpened() {
        return ticketsOpened;
    }

    public void setTicketsOpened(Integer ticketsOpened) {
        this.ticketsOpened = ticketsOpened;
    }

    public Integer getTicketsClosed() {
        return ticketsClosed;
    }

    public void setTicketsClosed(Integer ticketsClosed) {
        this.ticketsClosed = ticketsClosed;
    }

    public Integer getTicketsInProgress() {
        return ticketsInProgress;
    }

    public void setTicketsInProgress(Integer ticketsInProgress) {
        this.ticketsInProgress = ticketsInProgress;
    }

    public Integer getTicketsResolved() {
        return ticketsResolved;
    }

    public void setTicketsResolved(Integer ticketsResolved) {
        this.ticketsResolved = ticketsResolved;
    }

    public Integer getNbMails() {
        return nbMails;
    }

    public void setNbMails(Integer nbMails) {
        this.nbMails = nbMails;
    }
}
