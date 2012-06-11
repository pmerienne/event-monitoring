package com.pmerienne.eventmonitoring.server.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pmerienne.eventmonitoring.shared.model.Event;

public interface EventRepository extends MongoRepository<Event, String> {

	Page<Event> findByTypeIn(List<String> acceptedTypes, Pageable pageable);

	Page<Event> findByTypeInAndDateLessThan(List<String> acceptedTypes, Date minDate, Pageable pageable);
}
