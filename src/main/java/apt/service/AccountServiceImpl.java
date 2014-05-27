package apt.service;

import apt.dao.AccountDAO;
import apt.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Account getById(Long id) {
        return this.getAccountDAO().getById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Account create(Account account) {
        return this.getAccountDAO().create(account);
    }

    @Override
    @Transactional(readOnly = false)
    public Account update(Account account) {
        return this.getAccountDAO().update(account);
    }
}
