package com.mintsoftwaresystems.service;

import com.mintsoftwaresystems.model.Event;
import com.mintsoftwaresystems.model.Instructor;

import java.util.List;

public interface IEventService extends ICRUD<Event,Integer>{

    List<Event> getEventsByInstructorId(Integer instructorId);
}
