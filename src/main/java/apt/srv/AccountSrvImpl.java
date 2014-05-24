package apt.srv;

import apt.dao.AccountDAO;
import apt.model.Account;
import apt.model.InternalAccount;
import apt.model.LdapAccount;
import apt.utils.MethodsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Properties;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Service
@Transactional
public class AccountSrvImpl implements AccountSrv {

    @Autowired
    private AccountDAO<LdapAccount> ldapAccountAccountDAO;

    @Autowired
    private AccountDAO<InternalAccount> internalAccountDAO;

    @Autowired
    private Properties applicationProperties;

    public Properties getApplicationProperties() {
        return applicationProperties;
    }

    /**
     * Usually it shouldn't be used, when the user log in for the first time, the in base account should be created.
     * But this method is a test for creating account folder.
     *
     * @param account the account to create in database
     * @return the created account
     */
    @Override
    public LdapAccount create(LdapAccount account) {
        LdapAccount created = this.ldapAccountAccountDAO.save(account);
        File root = new File(this.getApplicationProperties().getProperty("repositories.path"));
        File child = new File(root, created.getUid());
        child.mkdirs();
        return created;
    }

    @Override
    public InternalAccount login(String login, String pass) {
        return this.internalAccountDAO.login(login, MethodsUtils.hashPass(pass));
    }
}
