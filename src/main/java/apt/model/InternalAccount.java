package apt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "internal_account")
@DiscriminatorValue("apt.model.InternalAccount")
public class InternalAccount extends Account {
    private static final long serialVersionUID = -2863593328505761671L;

    @Column(name = "username", nullable = false, unique = true)
    @JsonProperty(value = "username")
    private String username;

    @Column(name = "password", nullable = false)
    @JsonProperty(value = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
