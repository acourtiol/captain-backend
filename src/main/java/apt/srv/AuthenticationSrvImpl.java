package apt.srv;

import apt.dao.AuthenticationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jérémie Drouet on 21/05/14.
 */
@Service
@Transactional
public class AuthenticationSrvImpl implements AuthenticationSrv {

    @Autowired
    private AuthenticationDAO authenticationDAO;

    public AuthenticationDAO getAuthenticationDAO() {
        return authenticationDAO;
    }

    public void setAuthenticationDAO(AuthenticationDAO authenticationDAO) {
        this.authenticationDAO = authenticationDAO;
    }
}
