package apt.model;

import apt.model.enums.TicketState;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    String title;
    String description;

    @Column(nullable = false)
    TicketState state = TicketState.OPEN;

    @Column(nullable = false)
    Long projectId;

    Long accountId;
}
