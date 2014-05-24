package apt.ctrl;

import apt.dao.TicketDAO;
import apt.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@RestController
@RequestMapping("/ticket")
public class TicketsCtrl {

    @Autowired
    private TicketDAO ticketDAO;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json")
    public Ticket create(@RequestBody Ticket ticket) {
        return this.ticketDAO.save(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Ticket update(@RequestBody Ticket ticket) {
        return this.ticketDAO.merge(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@RequestBody Ticket ticket) {
        this.ticketDAO.delete(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getList", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Ticket> getList() {
        return this.ticketDAO.getList();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getList", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<Ticket> getList(@RequestBody Long projectId) {
        return this.ticketDAO.getList("projectId", projectId);
    }

}
