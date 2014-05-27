package apt.dao;

import apt.model.Account;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
@Repository
public class AccountDAOImpl extends GenericDAOImpl<Account> implements AccountDAO {

    @Override
    protected Class<Account> getType() {
        return Account.class;
    }
}