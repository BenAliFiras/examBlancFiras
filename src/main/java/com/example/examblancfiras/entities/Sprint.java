package com.example.examblancfiras.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String description;
    private Date startDate;
    @ManyToOne
    private Project project;
}

