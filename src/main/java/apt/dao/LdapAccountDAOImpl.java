package apt.dao;

import apt.model.LdapAccount;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Transactional
@Repository
public class LdapAccountDAOImpl extends GeneralDaoImpl<LdapAccount> implements AccountDAO<LdapAccount> {

    protected String getTableName() {
        return "account";
    }
    protected Class<LdapAccount> getType() {
        return LdapAccount.class;
    }

    @Override
    public LdapAccount login(String login, String hashPass) {
        //TODO
        return null;
    }
}
