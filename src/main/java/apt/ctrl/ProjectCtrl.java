package apt.ctrl;

import apt.dao.AccountDAO;
import apt.dao.ProjectDAO;
import apt.model.Account;
import apt.model.Project;
import apt.srv.ProjectSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@RestController
@RequestMapping("/project")
public class ProjectCtrl {

    @Autowired
    private ProjectSrv projectSrv;

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private AccountDAO<Account> accountDAO;

    public ProjectSrv getProjectSrv() {
        return projectSrv;
    }

    public void setProjectSrv(ProjectSrv projectSrv) {
        this.projectSrv = projectSrv;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_by_owner/{id_account}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Project> getByOwner(@PathVariable(value = "id_account") Long idAccount) {
        Account account = this.accountDAO.findOne("id", idAccount);
        return this.projectDAO.getList("owner", account);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json")
    public Project create(@RequestBody Project project) {
        return this.projectDAO.save(project);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_by_id/{id_project}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Project getById(@PathVariable(value = "id_project") Long projectId) {
        return this.projectDAO.findOne("idProject", projectId);
    }


}
