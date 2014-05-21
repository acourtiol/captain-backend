package apt.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author jeremie.drouet
 * @date 21/05/14
 */
@Component("transactionManager")
@EnableTransactionManagement
public class TransactionManager extends HibernateTransactionManager {
    private static final long serialVersionUID = 175261049130057366L;

    @Autowired
    private org.hibernate.SessionFactory sessionFactory;

    public org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
