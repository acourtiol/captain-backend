package apt.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class GeneralDaoImpl<T> implements GeneralDao<T> {

    protected abstract Class<T> getType();

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public T findOne(String param, Object value) {
        return (T) this.getSessionFactory().getCurrentSession().createCriteria(getType())
                .add(Restrictions.eq(param, value)).uniqueResult();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public T save(Object o) {
        Serializable id = this.getSessionFactory().getCurrentSession().save(o);
        return (T) this.getSessionFactory().getCurrentSession().get(getType(), id);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public T merge(T o) {
        return (T) this.getSessionFactory().getCurrentSession().merge(o);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void delete(Object o) {
        this.getSessionFactory().getCurrentSession().delete(o);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<T> getList(String param, Object value) {
            return this.getSessionFactory().getCurrentSession().createCriteria(getType())
                    .add(Restrictions.eq(param, value)).list();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List getList() {
        return this.getSessionFactory().getCurrentSession().createCriteria(getType()).list();
    }
}
