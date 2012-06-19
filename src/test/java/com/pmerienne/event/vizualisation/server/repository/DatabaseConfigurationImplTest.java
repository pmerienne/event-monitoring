package com.pmerienne.event.vizualisation.server.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.pmerienne.eventmonitoring.server.repository.DatabaseConfiguration;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;
import com.pmerienne.eventmonitoring.shared.model.administration.IndexKey;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class DatabaseConfigurationImplTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private DatabaseConfiguration databaseConfiguration;

	private DBCollection testCollection;

	@Before
	public void clearTestCollection() {
		this.testCollection = this.mongoTemplate.getCollection(this.mongoTemplate.getCollectionName(Event.class));
		this.testCollection.drop();
	}

	@Test
	public void testGetIndexes() {
		// Create an ascending index
		DBObject dateIndex = new BasicDBObject("date", 1);
		this.testCollection.ensureIndex(dateIndex);

		// Call repository
		List<Index> actualIndexes = this.databaseConfiguration.getIndexes();

		// Asserts result
		assertNotNull(actualIndexes);
		assertEquals(2, actualIndexes.size());

		Index actualDateIndex = actualIndexes.get(1);
		assertEquals("date", actualDateIndex.getKeys().get(0).getName());
		assertTrue(actualDateIndex.getKeys().get(0).getAscending());
	}

	@Test
	public void testEnsureIndex() {
		// Create an index
		List<IndexKey> keys = Arrays.asList(new IndexKey("data.duration", true));
		Index index = new Index(keys, true, true);

		// Call repository
		this.databaseConfiguration.ensureIndex(index);

		// Asserts result
		List<Index> actualIndexes = this.databaseConfiguration.getIndexes();
		assertNotNull(actualIndexes);
		assertEquals(2, actualIndexes.size());
		assertEquals(index, actualIndexes.get(1));
	}

	@Test
	public void testDropIndex() {
		// Create an ascending index
		DBObject dateIndex = new BasicDBObject("date", 1);
		this.testCollection.ensureIndex(dateIndex);

		// Drop an index
		List<IndexKey> keys = Arrays.asList(new IndexKey("date", true));
		Index index = new Index(keys, true, true);

		// Call repository
		this.databaseConfiguration.dropIndex(index);

		// Asserts result
		List<Index> actualIndexes = this.databaseConfiguration.getIndexes();
		assertNotNull(actualIndexes);
		assertEquals(1, actualIndexes.size());
	}
}
