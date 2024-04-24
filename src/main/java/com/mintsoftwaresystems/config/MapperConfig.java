package com.mintsoftwaresystems.config;

import com.mintsoftwaresystems.dto.EventDTO;
import com.mintsoftwaresystems.model.Event;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("eventMapper")
    public ModelMapper eventMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<EventDTO, Event> typeMap = mapper.createTypeMap(EventDTO.class, Event.class);
        typeMap.addMapping(EventDTO::getIdEvent, (dest, v) -> dest.setIdEvent((Integer) v));
        return mapper;
    }
}
