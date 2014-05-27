package apt.controller;

import apt.model.Account;
import apt.model.InternalAccount;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
public interface AccountController {

    public Account getById(Long idAccount);

    public Account create(InternalAccount account);

}
