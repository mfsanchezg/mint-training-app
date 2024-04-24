package com.mintsoftwaresystems.service.impl;

import com.mintsoftwaresystems.model.Event;
import com.mintsoftwaresystems.model.Instructor;
import com.mintsoftwaresystems.repo.IEventRepository;
import com.mintsoftwaresystems.repo.IGenericRepo;
import com.mintsoftwaresystems.repo.IInstructorRepository;
import com.mintsoftwaresystems.service.IEventService;
import com.mintsoftwaresystems.service.IInstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventServiceImpl extends CRUDImpl<Event, Integer> implements IEventService {

    private final IEventRepository repository;

    @Override
    protected IGenericRepo<Event, Integer> getRepo() {
        return repository;
    }

    @Override
    public List<Event> getEventsByInstructorId(Integer instructorId) {

        return repository.findByInstructor_IdInstructor(instructorId);
    }
}
