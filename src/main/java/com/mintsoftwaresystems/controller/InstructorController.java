package com.mintsoftwaresystems.controller;

import com.mintsoftwaresystems.service.IInstructorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
@Tag(name = "Instructor Controller", description = "Controller for manage the Instructors")
public class InstructorController {

    private final IInstructorService service;

    @GetMapping("/{id}/overallduration")
    public ResponseEntity<String> readByInstructorId(@PathVariable("id") Integer id) throws Exception{
        Long durationDays = service.getOverallDuration(id);
        return new ResponseEntity<>("The duration (days) for all the events with instructorId {" + id + "} are = " + durationDays, HttpStatus.OK);
    }
}
