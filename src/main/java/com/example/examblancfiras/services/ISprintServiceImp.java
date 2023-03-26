package com.example.examblancfiras.services;

import com.example.examblancfiras.entities.Project;
import com.example.examblancfiras.entities.Sprint;
import com.example.examblancfiras.repositories.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ISprintServiceImp implements ISprintServices {

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        Assert.notNull(project, "Entity must not be null.");
        //ki yabda 3andi objet jdid mahouch jey ml bd na3mlou 3 ligne hedhom:
        List<Sprint> sprints = new ArrayList<>();
        sprints.add(sprint);
        project.setSprints(sprints);
        //5ater 3andich list
        projectRepository.saveAndFlush(project);
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public void getNbrSprintByCurrentProject() {
        for ( Project p : projectRepository.findAll()) {
            log.info("le projet : "+ p.getTitle()+" : "+p.getSprints().size()+" sprints");
        }
    }
}
