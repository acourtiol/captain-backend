package apt.dao;


import java.util.List;

public interface GeneralDao<T> {
    public T findOne(String param, String value);
    public T save(T o);
    public void delete(T o);
    public List<T> getList(String param, String value);
    public List<T> getList();
}
