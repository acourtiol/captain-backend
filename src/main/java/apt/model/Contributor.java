package apt.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jeremie.drouet
 * @date 15/05/14
 */
@Entity
@Table(name = "contributor")
public class Contributor implements Serializable {
    private static final long serialVersionUID = -3856613496368153679L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    private Project project;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
