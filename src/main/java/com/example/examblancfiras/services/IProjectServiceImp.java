package com.example.examblancfiras.services;

import com.example.examblancfiras.entities.Project;
import com.example.examblancfiras.entities.Role;
import com.example.examblancfiras.entities.User;
import com.example.examblancfiras.repositories.ProjectRepository;
import com.example.examblancfiras.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IProjectServiceImp implements IProjectServices {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public Project addProject(Project project) {
        if(project.getSprints()!=null) {
            projectRepository.saveAndFlush(project);
            project.getSprints().forEach(sprint -> {
                sprint.setProject(project);
            });
        }
        return project;
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if ((project != null) && (user != null)){
            List<User> users = new ArrayList<>();
            users.add(user);
            project.setUsers(users);
            //departement.getEtudiants().add(etudiant);
            projectRepository.save(project);
        }
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findByFnameAndLname(firstName, lastName);

        if ((project != null) && (user != null)) {
            if (user.getRole().equals("CLIENT")) {
                List<User> users = new ArrayList<>();
                users.add(user);
                project.setUsers(users);
                //departement.getEtudiants().add(etudiant);
                projectRepository.save(project);
            }
        }
    }

    @Override
    public List<Project> getAllCurrentProject() {
        return projectRepository.findAllBySprintsStartdateGreaterThan(LocalDate.now());
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        return projectRepository.findAllByUserRoleAndUserFnameAndLname(Role.SCRUM_MASTER,fName,lName);
    }
}

