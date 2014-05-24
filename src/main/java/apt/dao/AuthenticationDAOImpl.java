package apt.dao;

import apt.model.Account;
import apt.model.Authentication;
import apt.srv.AuthenticationSrv;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Jérémie Drouet on 21/05/14.
 */
@Repository
public class AuthenticationDAOImpl extends GeneralDaoImpl<Authentication> implements AuthenticationDAO {

    protected String getTableName() {
        return "authentication";
    }
    protected Class<Authentication> getType() {
        return Authentication.class;
    }

}
