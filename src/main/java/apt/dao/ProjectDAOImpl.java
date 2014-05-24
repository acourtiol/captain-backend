package apt.dao;

import apt.model.Project;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author jeremie.drouet
 * @date 13/05/14
 */
@Transactional
@Repository
public class ProjectDAOImpl extends GeneralDaoImpl<Project> implements ProjectDAO {
    @Override
    protected Class<Project> getType() {
        return Project.class;
    }
}
