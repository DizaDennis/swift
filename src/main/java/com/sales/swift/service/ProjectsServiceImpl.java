package com.sales.swift.service;


import com.sales.swift.entities.Projects;
import com.sales.swift.repositories.ProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Business logic class for 'Projects'
 * Performs the tasks / implements methods defined in the ProjectsService class
 * @author dennisdiza
 */

@Service
public class ProjectsServiceImpl implements ProjectsService {

    //Bringing in the repo so that we can use it to access DB objects
    private ProjectsRepo projectsRepo;

    @Autowired
    public ProjectsServiceImpl(ProjectsRepo theProjectsRepo){
        this.projectsRepo = theProjectsRepo;


    }

    @Override
    public List<Projects> findAll() {
        return projectsRepo.findAllByOrderByCompanyNameAsc();
    }

    @Override
    public Projects findById(Long theId) {
        //Including 'Optional in case its not found'
        Optional<Projects> result = projectsRepo.findById(theId);
        Projects theProjects = null;

            if(result.isPresent()){
                theProjects = result.get();
            }
            else{
                throw new RuntimeException(theId + "Was not found");
            }

        return theProjects;
    }

    @Override
    public Projects save(Projects theProject) {
        return projectsRepo.save(theProject);
    }

    @Override
    public void deleteById(Long theId) {

        projectsRepo.deleteById(theId);
    }
}
