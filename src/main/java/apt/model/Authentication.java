package apt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * Created by Jérémie Drouet on 21/05/14.
 */
@Entity
@Table(name = "authentication")
public class Authentication implements Serializable {
    private static final long serialVersionUID = 8987805873685007449L;
    private static final int tokenLength = 32;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;

    @Id
    @Column(name = "insert_event", nullable = false)
    private Date insertEvent;

    @Column(name = "token", nullable = false)
    private String token;

    public Authentication() {
    }

    public Authentication(Account account) {
        this.account = account;
        this.insertEvent = new Date();
        this.token = generateToken();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getInsertEvent() {
        return insertEvent;
    }

    public void setInsertEvent(Date insertEvent) {
        this.insertEvent = insertEvent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static String generateToken() {
        StringBuffer sb = new StringBuffer();
        Random rand = new SecureRandom();
        for (int i = 0; i < tokenLength; i++) {
            if (rand.nextBoolean()) {
                sb.append((char) ('A' + rand.nextInt('Z' - 'A')));
            } else {
                sb.append(rand.nextInt(10));
            }
        }
        return sb.toString();
    }
}
