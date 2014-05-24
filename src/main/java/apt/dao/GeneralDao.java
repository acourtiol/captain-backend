package apt.dao;


import java.util.List;

public interface GeneralDao<T> {
    public T findOne(String param, Object value);
    public T save(T o);
    public void delete(T o);
    public List<T> getList(String param, Object value);
    public List<T> getList();
    public T merge(T o);
}
