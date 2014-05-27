package apt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ldap_account")
@DiscriminatorValue("apt.model.LdapAccount")
public class LdapAccount extends Account {
    private static final long serialVersionUID = -8054516752901693059L;

    @JsonProperty(value = "uid")
    @Column(name = "uid", unique = true, nullable = true)
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
