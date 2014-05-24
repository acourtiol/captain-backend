package apt.srv;

import apt.model.Account;
import apt.model.InternalAccount;
import apt.model.LdapAccount;

import java.io.IOException;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
public interface AccountSrv {

    public LdapAccount create(LdapAccount account);
    InternalAccount login(String login, String pass);

}
