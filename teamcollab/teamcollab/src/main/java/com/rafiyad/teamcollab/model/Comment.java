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
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String content; // Text content of the comment

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // User who created the comment

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task; // Task to which the comment is related

    @NotNull
    private LocalDateTime created_at; // Date and time when the comment was created


}
