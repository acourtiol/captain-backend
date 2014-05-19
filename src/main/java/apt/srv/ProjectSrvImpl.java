package apt.srv;

import apt.dao.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Service
@Transactional
public class ProjectSrvImpl implements ProjectSrv {

    @Autowired
    private ProjectDAO projectDAO;

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
}
