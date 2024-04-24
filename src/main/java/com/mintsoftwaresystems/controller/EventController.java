package com.mintsoftwaresystems.controller;

import com.mintsoftwaresystems.dto.EventDTO;
import com.mintsoftwaresystems.exception.EventNotFoundException;
import com.mintsoftwaresystems.model.Event;
import com.mintsoftwaresystems.service.IEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@Tag(name = "Event Controller", description = "Controller for manage the Events")
public class EventController {

    private final IEventService service;

    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EventDTO>> readByInstructorId(@RequestParam("instructor_id") Integer id) throws Exception{
        List<EventDTO> obj = service.getEventsByInstructorId(id).stream().map(this::convertToDto).collect(Collectors.toList());
        if(obj.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    private EventDTO convertToDto(Event obj) {
        return mapper.map(obj, EventDTO.class);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDto) throws Exception {
        Event obj = service.save(convertToEntity(eventDto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDTO> updateEvent(@Valid @RequestBody EventDTO eventDto) throws Exception {

        Event obj = service.readById(eventDto.getIdEvent());

        if(obj == null){
            throw new EventNotFoundException("Event Not Found: " + eventDto.getIdEvent());
        }

        Event event = service.update(convertToEntity(eventDto));
        return new ResponseEntity<>(convertToDto(event), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") Integer id) throws Exception {
        Event obj = service.readById(id);

        if (obj == null) {
            throw new EventNotFoundException("Event Not Found: " + id);
        }
        service.delete(obj.getIdEvent());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Event convertToEntity(EventDTO dto){
        return mapper.map(dto, Event.class);
    }

}
