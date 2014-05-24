package apt.ctrl;

import apt.model.Account;
import apt.model.InternalAccount;
import apt.model.LdapAccount;
import apt.srv.AccountSrv;
import apt.utils.MethodsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/get_by_id/{id_account}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Account getById(@PathVariable(value = "id_account") Long idAccount) {
        return null; // TODO
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/get_by_mail_address/{mail_address}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Account getByMailAddress(@PathVariable(value = "mail_address") String mailAddress) {
        return null; // TODO
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account create(@RequestBody LdapAccount account) {
        return this.getAccountSrv().create(account);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public InternalAccount login(@RequestBody Map<String, Object> params) {
        String login;
        String pass;
        if (null != params && params.containsKey("login") && params.containsKey("pass")) {
            login = (String) params.get("login");
            pass = (String) params.get("pass");
            return accountSrv.login(login, pass);
        }
        return null;
    }

}
