package com.mintsoftwaresystems.repo;

import com.mintsoftwaresystems.model.Event;
import com.mintsoftwaresystems.model.Instructor;

import java.util.List;

public interface IEventRepository extends IGenericRepo<Event, Integer>{

    List<Event> findByInstructor_IdInstructor(Integer instructorId);
}
