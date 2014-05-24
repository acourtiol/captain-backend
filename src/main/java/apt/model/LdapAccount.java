package apt.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("ldap")
public class LdapAccount extends Account {
    @Column(name = "uid", unique = true, nullable = true)
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
