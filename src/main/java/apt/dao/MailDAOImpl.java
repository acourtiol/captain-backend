package apt.dao;

import apt.model.Mail;
import apt.model.Ticket;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Repository
@Transactional
public class MailDAOImpl extends GeneralDaoImpl<Mail> implements MailDAO {

    @Override
    protected Class<Mail> getType() {
        return Mail.class;
    }

}
