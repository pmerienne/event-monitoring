package com.pmerienne.event.vizualisation.server.repository.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import com.pmerienne.eventmonitoring.server.repository.utils.CriteriaBuilder;
import com.pmerienne.eventmonitoring.shared.model.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class CriteriaBuilderTest {

	@Autowired
	private CriteriaBuilder criteriaBuilder;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void initTestData() {
		// Drop collection
		this.eventRepository.deleteAll();
	}

	@Test
	public void testBuildCriteria() {
		String criteriaQuery = "type == REQUEST AND data.duration > 300";

		// Test
		Criteria actualCriteria = this.criteriaBuilder.buildCriteria(criteriaQuery);

		// Assert
		assertNotNull(actualCriteria);
		assertEquals("{ \"$and\" : [ { \"type\" : \"REQUEST\"} , { \"data.duration\" : { \"$gt\" : 300}}]}", actualCriteria.getCriteriaObject().toString());
	}

	@Test
	public void testBuildCriteriaWithNull() {
		String criteriaQuery = "type == null";
		Criteria actualCriteria = this.criteriaBuilder.buildCriteria(criteriaQuery);
		assertEquals("{ \"type\" : { \"$exists\" : false}}", actualCriteria.getCriteriaObject().toString());

		criteriaQuery = "type != null";
		actualCriteria = this.criteriaBuilder.buildCriteria(criteriaQuery);
		assertEquals("{ \"type\" : { \"$exists\" : true}}", actualCriteria.getCriteriaObject().toString());
	}

	@Test
	public void testBuildCriteriaWithArithmeticOperators() {
		String criteriaQuery = "data.request.start - data.request.end  > 300";

		// Test
		Criteria actualCriteria = this.criteriaBuilder.buildCriteria(criteriaQuery);

		// Assert
		assertNotNull(actualCriteria);
		assertEquals("{ \"$where\" : \"(this.data.request.start-this.data.request.end)>300\"}", actualCriteria.getCriteriaObject().toString());
	}

	@Test
	public void testBuildCriteriaWithComplexArithmeticOperators() {
		String criteriaQuery = "data.duration > data.sduration * (data.tada - 0.5)";

		// Test
		Criteria actualCriteria = this.criteriaBuilder.buildCriteria(criteriaQuery);

		// Assert
		assertNotNull(actualCriteria);
		assertEquals("{ \"$where\" : \"this.data.duration>(this.data.sduration*(this.data.tada-0.5))\"}", actualCriteria.getCriteriaObject().toString());
	}

	@Test
	public void testBuildCriteriaWithFieldComparaison() {
		String criteriaQuery = "type == RESPONSE AND data.duration > data.request.duration ";

		// Test
		Criteria actualCriteria = this.criteriaBuilder.buildCriteria(criteriaQuery);

		// Assert
		assertNotNull(actualCriteria);
		assertEquals("{ \"$and\" : [ { \"type\" : \"RESPONSE\"} , { \"$where\" : \"this.data.duration>this.data.request.duration\"}]}", actualCriteria
				.getCriteriaObject().toString());
	}

	@Test
	public void testBuildCriteriaWithComplexQuery() {
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

		Event event7 = new Event("RESPONSE");
		event7.addData("status", 500);
		event7.addData("component", "http://mediadb.4rnd.com");
		event7.setDate(null);
		this.eventRepository.save(event7);

		// Test
		String criteriaQuery = "date != null AND ((type == REQUEST && data.duration > 300) OR (type == RESPONSE && (data.status < 200 || data.status >= 300))) AND data.component == http://mediadb.4rnd.com";
		Criteria actualCriteria = this.criteriaBuilder.buildCriteria(criteriaQuery);

		// Assert
		// Use query with mongo template
		Query query = Query.query(actualCriteria);
		List<Event> actualEvents = this.mongoTemplate.find(query, Event.class);

		// Assert results
		assertEquals(3, actualEvents.size());
		assertTrue(actualEvents.contains(event2));
		assertTrue(actualEvents.contains(event4));
		assertTrue(actualEvents.contains(event5));
	}

}
