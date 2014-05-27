package apt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
public abstract class Account implements Serializable {
    private static final long serialVersionUID = -6070188485677954082L;

    @Id
    @Column(name = "id_account")
    @JsonProperty(value = "id_account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccount;

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long id) {
        this.idAccount = id;
    }

    @Transient
    public String getType() {
        return this.getClass().getName();
    }

    @JsonIgnore
    public void setType(String type) {
    }
}
