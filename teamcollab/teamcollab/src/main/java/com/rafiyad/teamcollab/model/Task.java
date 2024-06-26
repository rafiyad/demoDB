package com.rafiyad.teamcollab.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Component
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private String status; // To Do, In Progress, Done

    @NotNull
    private String priority; // Low, Medium, High

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo; // Nullable, as task might not be assigned to anyone

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @NotNull
    private LocalDateTime created_at;

    private LocalDateTime due_date;

}
