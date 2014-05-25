package apt.dao;

import apt.model.Project;
import apt.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Repository
@Transactional
public class TicketDAOImpl extends GeneralDaoImpl<Ticket> implements TicketDAO {

    @Override
    protected Class<Ticket> getType() {
        return Ticket.class;
    }

}
