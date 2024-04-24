package com.mintsoftwaresystems.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvent;

    @Enumerated(EnumType.STRING)
    private EventTypeEnum eventType;

    private LocalDateTime initialDate;

    private LocalDateTime finalDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_instructor", nullable = false)
    private Instructor instructor;

}
