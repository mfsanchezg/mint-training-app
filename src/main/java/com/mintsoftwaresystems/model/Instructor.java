package com.mintsoftwaresystems.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInstructor;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDay;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //fetch = FetchType.EAGER
    private List<Event> events;
}
