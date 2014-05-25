package apt.model;

import apt.model.enums.MailState;

import javax.persistence.*;

@Entity
@Table(name = "mail")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mail", nullable = false)
    private Long idMail;

    @Column(nullable = false)
    private String sender;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    private Project project;

    @Column(nullable = false)
    private String subject;
    @Column(length = 2048)
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    MailState state = MailState.UNREAD;

    public Long getIdMail() {
        return idMail;
    }

    public void setIdMail(Long idMail) {
        this.idMail = idMail;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MailState getState() {
        return state;
    }

    public void setState(MailState state) {
        this.state = state;
    }
}
