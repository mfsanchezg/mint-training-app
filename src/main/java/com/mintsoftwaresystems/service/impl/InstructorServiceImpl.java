package com.mintsoftwaresystems.service.impl;

import com.mintsoftwaresystems.dto.EventDTO;
import com.mintsoftwaresystems.model.Instructor;
import com.mintsoftwaresystems.repo.IGenericRepo;
import com.mintsoftwaresystems.repo.IInstructorRepository;
import com.mintsoftwaresystems.service.IInstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@RequiredArgsConstructor
@Service
public class InstructorServiceImpl extends CRUDImpl<Instructor, Integer> implements IInstructorService {

    private final IInstructorRepository repository;

    @Override
    protected IGenericRepo<Instructor, Integer> getRepo() {
        return repository;
    }

    @Override
    public Long getOverallDuration(Integer id) {


        return repository.findAll().stream()
                .filter(instructor -> Objects.equals(instructor.getIdInstructor(), id))
                .flatMap(instructor -> instructor.getEvents().stream())
                .map(event -> ChronoUnit.DAYS.between(event.getInitialDate(), event.getFinalDate()))
                .mapToLong(Long::longValue)
                .sum();
    }
}
