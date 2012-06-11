package com.pmerienne.event.vizualisation.server.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pmerienne.eventmonitoring.server.repository.EventRepository;
import com.pmerienne.eventmonitoring.server.repository.EventSearcher;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest.SortedField;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class EventSearcherImplTest {

	@Autowired
	private EventSearcher eventSearcher;

	@Autowired
	private EventRepository eventRepository;

	@Before
	public void initTestData() {
		// Drop collection
		this.eventRepository.deleteAll();
	}

	@Test
	public void testSearchWithTimeSerieRequest() {
		// Expected data
		Long now = new Date().getTime();
		Long interval = 5000L;
		SerieConfiguration serieConfiguration = new SerieConfiguration();
		serieConfiguration.setInterval(interval);
		serieConfiguration.setCriteriaQuery("type == REQUEST");
		serieConfiguration.setProjectionQuery("sum(data.duration)");
		TimeSerieRequest request = new TimeSerieRequest(serieConfiguration, new Date(now - 12 * interval), new Date(now));

		Event event1 = new Event("REQUEST", new Date(now - 10 * interval));
		event1.addData("duration", 100);
		this.eventRepository.save(event1);
		Event event2 = new Event("REQUEST", new Date(now - 10 * interval + interval / 10));
		event2.addData("duration", 200);
		this.eventRepository.save(event2);
		Event event3 = new Event("REQUEST", new Date(now - 5 * interval));
		event3.addData("duration", 300);
		this.eventRepository.save(event3);
		Event event4 = new Event("RESPONSE", new Date(now - 5 * interval + interval / 10));
		event4.addData("duration", 400);
		this.eventRepository.save(event4);

		// Test
		TimeSerieResults actualResults = this.eventSearcher.search(request);

		// Assert
		assertNotNull(actualResults);
		assertEquals(2, actualResults.getData().size());
		assertEquals((Double) 300.0, actualResults.getData().get(0).getValue());
		assertEquals((Double) 300.0, actualResults.getData().get(1).getValue());
	}

	@Test
	public void testSearchWithSearchRequest() {
		TableConfiguration tableConfiguration = new TableConfiguration("test", 20, 60 * 60 * 1000L);
		tableConfiguration.setCriteria("(type == REQUEST && data.duration < 150) || (type == RESPONSE && data.duration > 350)");
		SearchRequest request = new SearchRequest(tableConfiguration, 0, 20, new ArrayList<SortedField>());

		Event event1 = new Event("REQUEST");
		event1.addData("duration", 100);
		this.eventRepository.save(event1);
		Event event2 = new Event("REQUEST");
		event2.addData("duration", 200);
		this.eventRepository.save(event2);
		Event event3 = new Event("REQUEST");
		event3.addData("duration", 300);
		this.eventRepository.save(event3);
		Event event4 = new Event("RESPONSE");
		event4.addData("duration", 400);
		this.eventRepository.save(event4);

		// Test
		SearchResults actualResults = this.eventSearcher.search(request);

		// Assert
		assertNotNull(actualResults);
		assertEquals(2, actualResults.getEvents().size());
		assertEquals(event1, actualResults.getEvents().get(0));
		assertEquals(event4, actualResults.getEvents().get(1));
	}
}
