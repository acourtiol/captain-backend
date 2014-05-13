package apt.srv;

import apt.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Service
@Transactional
public class AccountSrvImpl implements AccountSrv {

    @Autowired
    private AccountDAO accountDAO;

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
