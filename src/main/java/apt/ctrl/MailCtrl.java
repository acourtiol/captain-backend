package apt.ctrl;

import apt.dao.MailDAO;
import apt.dao.ProjectDAO;
import apt.model.Mail;
import apt.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@RestController
@RequestMapping("/mail")
public class MailCtrl {

    @Autowired
    private MailDAO mailDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_by_id/{id_mail}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Mail getById(@PathVariable(value = "id_mail") Long idMail) {
        return this.mailDAO.findOne("idMail", idMail);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_list/{project_id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Mail> getList(@PathVariable(value = "project_id") Long projectId) {
        Project project = this.projectDAO.findOne("idProject", projectId);
        return this.mailDAO.getList("project", project);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Mail update(@RequestBody Mail mail) {
        return this.mailDAO.merge(mail);
    }

}
