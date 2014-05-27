package apt.service;

import java.io.Serializable;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
public interface GenericService<T, S> {

    public T getById(S id);

    public T create(T object);

    public T update(T object);

}
