package apt.dao;

import apt.model.InternalAccount;
import apt.utils.MethodsUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public InternalAccount login(String login, String hashPass) {
        return (InternalAccount) this.getSessionFactory().getCurrentSession().createCriteria(InternalAccount.class)
                .add(Restrictions.and(
                        Restrictions.eq("username", login),
                        Restrictions.eq("password", hashPass)
                )).uniqueResult();
    }

}