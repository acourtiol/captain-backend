package apt.service;

import apt.dao.ProjectDAO;
import apt.model.Account;
import apt.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Project getById(Long id) {
        return this.getProjectDAO().getById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Project create(Project object) {
        return this.getProjectDAO().create(object);
    }

    @Override
    @Transactional(readOnly = false)
    public Project update(Project object) {
        return this.getProjectDAO().update(object);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> getByOwner(Account owner) {
        return this.getProjectDAO().get("owner", owner);
    }
}
