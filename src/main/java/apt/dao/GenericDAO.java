package apt.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
public interface GenericDAO<T> {

    public T getById(Serializable id);

    public List<T> get(String param, Object value);

    public T create(T object);

    public T update(T object);
}
