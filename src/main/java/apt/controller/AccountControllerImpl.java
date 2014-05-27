package apt.controller;

import apt.model.Account;
import apt.model.InternalAccount;
import apt.model.LdapAccount;
import apt.service.AccountService;
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
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_by_id/{id_account}", method = RequestMethod.GET)
    public Account getById(@PathVariable(value = "id_account") Long idAccount) {
        return this.getAccountService().getById(idAccount);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/create/internal", method = RequestMethod.POST)
    public Account create(@RequestBody InternalAccount account) {
        return this.getAccountService().create(account);
    }

}
