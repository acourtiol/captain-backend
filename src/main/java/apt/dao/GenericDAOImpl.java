package apt.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected abstract Class<T> getType();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T getById(Serializable id) {
        return (T) this.getSessionFactory().getCurrentSession().get(this.getType(), id);
    }

    public List<T> get(String param, Object value) {
        return this.getSessionFactory().getCurrentSession().createCriteria(this.getType())
                .add(Restrictions.eq(param, value)).list();
    }

    public T create(T object) {
        return this.getById(this.getSessionFactory().getCurrentSession().save(object));
    }

    public T update(T object) {
        this.getSessionFactory().getCurrentSession().update(object);
        return object;
    }

}
