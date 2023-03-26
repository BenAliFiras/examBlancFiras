package com.example.examblancfiras.controllers;

import com.example.examblancfiras.entities.Sprint;
import com.example.examblancfiras.services.ISprintServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sprint")
@RequiredArgsConstructor
public class SprintController {
    private final ISprintServices iSpintServices;
    @PostMapping("/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable int idProject){
        iSpintServices.addSprintAndAssignToProject(sprint,idProject);
    }
}

