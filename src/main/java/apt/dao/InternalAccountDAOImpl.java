package apt.dao;

import apt.model.InternalAccount;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Repository
public class InternalAccountDAOImpl extends GeneralDaoImpl<InternalAccount> implements AccountDAO<InternalAccount> {

    protected Class<InternalAccount> getType() {
        return InternalAccount.class;
    }

    @Override
    public InternalAccount login(String login, String hashPass) {
        Query q = this.getSessionFactory().getCurrentSession().createQuery("from Account a where a.username = :user and a.password = :pass");
        q.setParameter("user", login);
        q.setParameter("pass", hashPass);

        Iterator it = q.iterate();
        if(it.hasNext())
            return (InternalAccount) it.next();

        return null;
    }

}
