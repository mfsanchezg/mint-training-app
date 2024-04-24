package com.mintsoftwaresystems.service;

import com.mintsoftwaresystems.model.Instructor;

import java.util.Map;

public interface IInstructorService extends ICRUD<Instructor,Integer> {


    Long getOverallDuration(Integer id);
}
