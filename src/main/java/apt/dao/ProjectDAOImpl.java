package apt.dao;

import apt.model.Project;
import org.springframework.stereotype.Repository;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
@Repository
public class ProjectDAOImpl extends GenericDAOImpl<Project> implements ProjectDAO {
    @Override
    protected Class<Project> getType() {
        return Project.class;
    }
}
