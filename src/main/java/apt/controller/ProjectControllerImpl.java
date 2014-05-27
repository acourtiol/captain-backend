package apt.controller;

import apt.model.Account;
import apt.model.Project;
import apt.service.AccountService;
import apt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
@RestController
@RequestMapping("/project")
public class ProjectControllerImpl implements ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private AccountService accountService;

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_by_id/{id_project}", method = RequestMethod.GET)
    public Project getById(@PathVariable("id_project") Long id) {
        return this.getProjectService().getById(id);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get_by_owner/{id_owner}", method = RequestMethod.GET)
    public List<Project> getByOwner(@PathVariable("id_owner") Long idOwner) {
        Account account = this.getAccountService().getById(idOwner);
        return this.getProjectService().getByOwner(account);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Project create(@RequestBody Project project) {
        return this.getProjectService().create(project);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Project update(@RequestBody Project project) {
        return this.getProjectService().update(project);
    }
}
