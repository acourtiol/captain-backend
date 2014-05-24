package apt.ctrl;

import apt.srv.AuthenticationSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jérémie Drouet on 21/05/14.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationCtrl {

    @Autowired
    private AuthenticationSrv authenticationSrv;

    public AuthenticationSrv getAuthenticationSrv() {
        return authenticationSrv;
    }

    public void setAuthenticationSrv(AuthenticationSrv authenticationSrv) {
        this.authenticationSrv = authenticationSrv;
    }

}
