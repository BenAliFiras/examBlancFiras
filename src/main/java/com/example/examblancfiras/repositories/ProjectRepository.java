package com.example.examblancfiras.repositories;

import com.example.examblancfiras.entities.Project;
import com.example.examblancfiras.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    //List<Project> findBySprintsstartDateAfter(Date startDate);
    List<Project> findAllBySprintsStartdateGreaterThan(LocalDate date);

    List<Project> findAllByUserRoleAndUserFnameAndLname(Role role, String fn, String ln);
}

