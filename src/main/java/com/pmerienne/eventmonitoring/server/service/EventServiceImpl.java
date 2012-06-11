package com.pmerienne.eventmonitoring.server.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.pmerienne.eventmonitoring.server.repository.EventRepository;
import com.pmerienne.eventmonitoring.server.repository.EventSearcher;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventSearcher eventSearcher;

	@Override
	public SearchResults search(SearchRequest request) {
		// Check request
		if (request.getStart() == null || request.getStart() < 0) {
			request.setStart(0);
		}
		if (request.getEnd() == null || request.getEnd() < request.getStart()) {
			request.setEnd(request.getStart() + request.getTableConfiguration().getNbResults());
		}

		SearchResults results = this.eventSearcher.search(request);
		return results;
	}

	@Override
	public TimeSerieResults search(TimeSerieRequest request) {
		TimeSerieResults datas = this.eventSearcher.search(request);
		return datas;
	}

	@Async
	@Override
	public void add(Event event) {
		this.eventRepository.save(event);
	}

	@Scheduled(fixedRate = 1000)
	public void addRandomEvents() {
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			Date startDate = new Date(new Date().getTime() - random.nextInt(10000));
			Date endDate = new Date(startDate.getTime() + random.nextInt(2000));
			Date eventDate = new Date(endDate.getTime() + random.nextInt(500));
			String type = random.nextDouble() > 0.7 ? "REQUEST" : "RESPONSE";
			Event event = new Event(type);
			event.setDate(new Date(new Date().getTime() + random.nextInt(2000)));
			event.addData("start", startDate.getTime());
			event.addData("end", endDate.getTime());
			event.addData("duration", endDate.getTime() - startDate.getTime());
			event.addData("url", "http://media" + random.nextInt(5) + 1 + ".4rnd.com");
			event.setDate(eventDate);
			this.eventRepository.save(event);
		}
	}
}
