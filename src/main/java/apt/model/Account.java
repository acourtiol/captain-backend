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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_account", nullable = false)
    private Long idAccount;

    @Column(name = "mail_address", nullable = false, unique = true)
    private String mailAddress;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
