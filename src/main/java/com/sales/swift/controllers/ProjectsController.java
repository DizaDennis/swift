package com.sales.swift.controllers;


import com.sales.swift.entities.Projects;
import com.sales.swift.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Controller class defining the different end points that utilise the methods from the Service class
 * ProjectsService is brought in to access the methods
 */


@Controller
@RequestMapping("/projects")
public class ProjectsController {

    private ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService theProjectsService){
        projectsService = theProjectsService;
    }

    @GetMapping("/list")
    public String listProjects(Model model){

        List<Projects> theProject = projectsService.findAll();

        model.addAttribute("project", theProject);

        return "projects/projects-list";

    }

    @GetMapping("/newProjectForm")
    public String newProjectForm(Model model){

        Projects theProject = new Projects();
        model.addAttribute("project", theProject);

        return "projects/addProject-form";

    }

    /**
     *
     * @param theId - brought in from the frontend ->(projectsId = ${tempProject.Id})
     * @param model - used to bind the data for the view
     * @return - a prepopulated form with data found in the DB after using the id to query it
     */
    @GetMapping("/updateProject")
    public String updateProject(@RequestParam("projectsId")Long theId, Model model){

        //DB Query using the ID passed from the view
        Projects theProject = projectsService.findById(theId);

        //Binding the data found by the query to prepopulate the form
        model.addAttribute("project",theProject);

        return "projects/addProject-form";

    }
    @GetMapping("/deleteProject")
    public String deleteProject(@RequestParam("projectsId")Long theId){

        projectsService.deleteById(theId);

        return "redirect:/projects/list"; //redirecting used to point to a different endpoint - not a form

    }

    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Projects theProject){
        projectsService.save(theProject);

        return "redirect:/projects/list";
    }

}
