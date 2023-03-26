package com.example.examblancfiras.services;

import com.example.examblancfiras.entities.Sprint;
import org.springframework.stereotype.Service;

@Service
public interface ISprintServices {
    public void addSprintAndAssignToProject(Sprint sprint, int idProject);

    public void getNbrSprintByCurrentProject();
}
