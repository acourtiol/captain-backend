package apt.ctrl;

import apt.dao.ProjectDAO;
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

    public ProjectSrv getProjectSrv() {
        return projectSrv;
    }

    public void setProjectSrv(ProjectSrv projectSrv) {
        this.projectSrv = projectSrv;
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/get_by_owner/{id_account}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Project> getByOwner(@PathVariable(value = "id_account") Long idAccount) {
        return new ArrayList<Project>(); // TODO
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/get_by_owner_and_name/{id_account}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Project getByOwnerAndName(@PathVariable(value = "id_account") Long idAccount, @PathVariable(value = "name") String name) {
        return null; // TODO
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json")
    public Project create(@RequestBody Project project) {
        return this.projectDAO.save(project);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_by_id", method = RequestMethod.POST, headers = "Accept=application/json")
    public Project getById(@RequestBody Long projectId) {
        return this.projectDAO.findOne("idProject", projectId);
    }


}
