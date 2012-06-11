package com.pmerienne.event.vizualisation.server.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pmerienne.eventmonitoring.server.repository.EventRepository;
import com.pmerienne.eventmonitoring.shared.model.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class MongoQueryTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private EventRepository eventRepository;

	@Before
	public void initTestData() {
		// Drop collection
		this.eventRepository.deleteAll();
	}

	/**
	 * Test a very simple query :
	 * 
	 * <pre>
	 * (type == REQUEST)
	 * </pre>
	 */
	@Test
	public void testSimpleQuery() {
		// Create some data
		Event event1 = new Event("REQUEST");
		event1.addData("duration", 300);
		event1.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event1);

		Event event2 = new Event("REQUEST");
		event2.addData("duration", 100);
		event2.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event2);

		Event event3 = new Event("RESPONSE");
		event3.addData("status", 404);
		event3.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event3);

		// Create query
		Query query = Query.query(where("type").is("REQUEST"));

		// Use query with mongo template
		List<Event> actualEvents = this.mongoTemplate.find(query, Event.class);

		// Assert results
		assertEquals(2, actualEvents.size());
		assertTrue(actualEvents.contains(event1));
		assertTrue(actualEvents.contains(event2));
	}

	/**
	 * Test a query with and
	 * 
	 * <pre>
	 * (type == REQUEST &amp;&amp; data.duration &gt; 200)
	 * </pre>
	 */
	@Test
	public void testSimpleQueryWithAnd() {
		// Create some data
		Event event1 = new Event("REQUEST");
		event1.addData("duration", 300);
		event1.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event1);

		Event event2 = new Event("REQUEST");
		event2.addData("duration", 100);
		event2.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event2);

		Event event3 = new Event("RESPONSE");
		event3.addData("status", 404);
		event3.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event3);

		// Create query
		Criteria mainCriteria = new Criteria();
		Criteria typeCriteria = where("type").is("REQUEST");
		Criteria durationCriteria = where("data.duration").gt(200);
		Query query = Query.query(mainCriteria.andOperator(typeCriteria, durationCriteria));

		// Use query with mongo template
		List<Event> actualEvents = this.mongoTemplate.find(query, Event.class);

		// Assert results
		assertEquals(1, actualEvents.size());
		assertTrue(actualEvents.contains(event1));
	}

	/**
	 * Test a query with and on the same field
	 * 
	 * <pre>
	 * (data.duration &lt; 250 &amp;&amp; data.duration &gt; 150)
	 * </pre>
	 */
	@Test
	public void testSimpleQueryWithAndOnSameField() {
		// Create some data
		Event event1 = new Event("REQUEST");
		event1.addData("duration", 100);
		event1.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event1);

		Event event2 = new Event("REQUEST");
		event2.addData("duration", 200);
		event2.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event2);

		Event event3 = new Event("REQUEST");
		event3.addData("duration", 300);
		event3.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event3);

		// Create query
		Criteria mainCriteria = new Criteria();
		Criteria durationGTCriteria = where("data.duration").gt(150);
		Criteria durationLTCriteria = where("data.duration").lt(250);
		Query query = Query.query(mainCriteria.andOperator(durationGTCriteria, durationLTCriteria));

		// Use query with mongo template
		List<Event> actualEvents = this.mongoTemplate.find(query, Event.class);

		// Assert results
		assertEquals(1, actualEvents.size());
		assertTrue(actualEvents.contains(event2));
	}

	/**
	 * Test a query with or
	 * 
	 * <pre>
	 * (data.component == http://staging.mediadb.4rnd.com || data.component == http://integration.mediadb.4rnd.com)
	 * </pre>
	 */
	@Test
	public void testSimpleQueryWithOr() {
		// Create some data
		Event event1 = new Event("REQUEST");
		event1.addData("duration", 100);
		event1.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event1);

		Event event2 = new Event("REQUEST");
		event2.addData("duration", 200);
		event2.addData("component", "http://staging.mediadb.4rnd.com");
		this.eventRepository.save(event2);

		Event event3 = new Event("REQUEST");
		event3.addData("duration", 300);
		event3.addData("component", "http://integration.mediadb.4rnd.com");
		this.eventRepository.save(event3);

		// Create query
		Criteria mainCriteria = new Criteria();
		Criteria stagingCriteria = where("data.component").is("http://staging.mediadb.4rnd.com");
		Criteria integrationCriteria = where("data.component").is("http://integration.mediadb.4rnd.com");
		Query query = Query.query(mainCriteria.orOperator(stagingCriteria, integrationCriteria));

		// Use query with mongo template
		List<Event> actualEvents = this.mongoTemplate.find(query, Event.class);

		// Assert results
		assertEquals(2, actualEvents.size());
		assertTrue(actualEvents.contains(event2));
		assertTrue(actualEvents.contains(event3));
	}

	/**
	 * Let's search for bad event happening in production!
	 * 
	 * <pre>
	 * ((type == REQUEST && data.duration > 300) OR (type == RESPONSE && (data.status < 200 || data.status >= 300))) AND data.component == http://mediadb.4rnd.com
	 * </pre>
	 */
	@Test
	public void testComplexQuery() {
		// Create some data
		Event event1 = new Event("REQUEST");
		event1.addData("duration", 200);
		event1.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event1);

		Event event2 = new Event("REQUEST");
		event2.addData("duration", 400);
		event2.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event2);

		Event event3 = new Event("REQUEST");
		event3.addData("duration", 400);
		event3.addData("component", "http://integration.mediadb.4rnd.com");
		this.eventRepository.save(event3);

		Event event4 = new Event("RESPONSE");
		event4.addData("status", 404);
		event4.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event4);

		Event event5 = new Event("RESPONSE");
		event5.addData("status", 500);
		event5.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event5);

		Event event6 = new Event("RESPONSE");
		event6.addData("status", 200);
		event6.addData("component", "http://mediadb.4rnd.com");
		this.eventRepository.save(event6);

		// Create criteria on request
		Criteria durationCriteria = where("data.duration").gt(300);
		Criteria requestCriteria = new Criteria().andOperator(where("type").is("REQUEST"), durationCriteria);

		// Create criteria on response
		Criteria statusCriteria = new Criteria().orOperator(where("data.status").lt(200), where("data.status").gte(300));
		Criteria responseCriteria = new Criteria().andOperator(where("type").is("RESPONSE"), statusCriteria);

		// Create criteria on badness!
		Criteria badEventCriteria = new Criteria().orOperator(responseCriteria, requestCriteria);

		// Create criteria on env
		Criteria productionCriteria = where("data.component").is("http://mediadb.4rnd.com");

		// Assemble criteria
		Criteria badEventInProductionCriteria = new Criteria().andOperator(productionCriteria, badEventCriteria);

		// Use query with mongo template
		Query query = Query.query(badEventInProductionCriteria);
		List<Event> actualEvents = this.mongoTemplate.find(query, Event.class);

		// Assert results
		assertEquals(3, actualEvents.size());
		assertTrue(actualEvents.contains(event2));
		assertTrue(actualEvents.contains(event4));
		assertTrue(actualEvents.contains(event5));
	}
}
