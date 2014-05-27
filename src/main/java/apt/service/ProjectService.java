package apt.service;

import apt.model.Account;
import apt.model.Project;

import java.util.List;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
public interface ProjectService extends GenericService<Project, Long> {

    public List<Project> getByOwner(Account owner);

}
