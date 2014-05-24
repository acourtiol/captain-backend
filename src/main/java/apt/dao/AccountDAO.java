package apt.dao;

import apt.model.Account;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
public interface AccountDAO<T> extends GeneralDao<T> {
    T login(String login, String hashPass);
}
