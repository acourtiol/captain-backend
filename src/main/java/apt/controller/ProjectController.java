package apt.controller;

import apt.model.Project;

import java.util.List;

/**
 * Created by Jérémie Drouet on 26/05/14.
 */
public interface ProjectController {

    public Project getById(Long id);

    public List<Project> getByOwner(Long idOwner);

    public Project create(Project project);

    public Project update(Project project);

}
