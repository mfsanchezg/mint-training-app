package com.mintsoftwaresystems.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mintsoftwaresystems.model.EventTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDTO {

    private Integer idEvent;

    private EventTypeEnum eventType;

    private LocalDateTime initialDate;

    private LocalDateTime finalDate;

    private String description;

    @JsonBackReference
    private InstructorDTO instructor;
}
