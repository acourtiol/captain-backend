package apt.dao;

import apt.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Repository
public class AccountDAOImpl extends GeneralDaoImpl<Account> implements AccountDAO<Account> {

    protected String getTableName() {
        return "account";
    }

    @Override
    protected Class<Account> getType() {
        return Account.class;
    }

    @Override
    public Account login(String login, String hashPass) {
        //TODO
        return null;
    }
}
