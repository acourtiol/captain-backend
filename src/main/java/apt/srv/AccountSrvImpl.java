package apt.srv;

import apt.dao.AccountDAO;
import apt.model.Account;
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
    private AccountDAO accountDAO;

    @Autowired
    private Properties applicationProperties;

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Properties getApplicationProperties() {
        return applicationProperties;
    }

    public void setApplicationProperties(Properties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    /**
     * Usually it shouldn't be used, when the user log in for the first time, the in base account should be created.
     * But this method is a test for creating account folder.
     *
     * @param account the account to create in database
     * @return the created account
     */
    @Override
    public Account create(Account account) {
        Account created = this.getAccountDAO().create(account);
        File root = new File(this.getApplicationProperties().getProperty("repositories.path"));
        File child = new File(root, created.getUid());
        child.mkdirs();
        return created;
    }
}
