package com.example.examblancfiras.controllers;

import com.example.examblancfiras.entities.Project;
import com.example.examblancfiras.services.IProjectServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectServices iProjectServices;
    @PostMapping("/add")
    public Project addProject (@RequestBody Project project){
        return iProjectServices.addProject(project);
    }

    @PostMapping("/{projectId}/{userId}")
    public void assignProjectToUser (@PathVariable int projectId, @PathVariable int userId){
        iProjectServices.assignProjectToUser(projectId,userId);
    }

    @PostMapping("/{projectId}")
    public void assignProjectToClient(@PathVariable int projectId, @RequestBody String firstName, @RequestBody String lastName){
        iProjectServices.assignProjectToClient(projectId,firstName,lastName);
    }

    @GetMapping("/allCurrentP")
    public List<Project> getAllCurrentProject(){
        return iProjectServices.getAllCurrentProject();
    }

    @GetMapping("/PScrumMaster")
    public List<Project> getProjectsByScrumMaster(String fName, String lName){
        return iProjectServices.getProjectsByScrumMaster(fName,lName);
    }
}

