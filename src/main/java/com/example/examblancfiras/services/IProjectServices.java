package com.example.examblancfiras.services;

import com.example.examblancfiras.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProjectServices {
    public Project addProject (Project project);

    public void assignProjectToUser (int projectId, int userId);

    public void assignProjectToClient(int projectId, String firstName, String lastName);

    public List<Project> getAllCurrentProject();

    public List<Project> getProjectsByScrumMaster(String fName, String lName);
}
