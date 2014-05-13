package apt.ctrl;

import apt.model.Account;
import apt.srv.AccountSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@RestController
@RequestMapping("/account")
public class AccountCtrl {

    @Autowired
    private AccountSrv accountSrv;

    public AccountSrv getAccountSrv() {
        return accountSrv;
    }

    public void setAccountSrv(AccountSrv accountSrv) {
        this.accountSrv = accountSrv;
    }

    @RequestMapping(value = "/get_by_mail_address/{id_account}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Account getById(@PathVariable(value = "id_account") Long idAccount) {
        return null; // TODO
    }

    @RequestMapping(value = "/get_by_mail_address/{mail_address}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Account getByMailAddress(@PathVariable(value = "mail_address") String mailAddress) {
        return null; // TODO
    }

}
