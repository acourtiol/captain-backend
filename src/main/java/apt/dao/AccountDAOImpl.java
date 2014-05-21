package apt.dao;

import apt.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Account create(Account account) {
        Serializable id = this.getSessionFactory().getCurrentSession().save(account);
        return (Account) this.getSessionFactory().getCurrentSession().get(Account.class, id);
    }

    // TODO
}
