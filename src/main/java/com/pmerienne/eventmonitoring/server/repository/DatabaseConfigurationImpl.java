package com.pmerienne.eventmonitoring.server.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;
import com.pmerienne.eventmonitoring.shared.model.administration.IndexKey;

@Repository
public class DatabaseConfigurationImpl implements DatabaseConfiguration, InitializingBean {

	@Autowired
	private MongoTemplate mongoTemplate;

	private String eventCollectionName;

	@Override
	public List<Index> getIndexes() {
		List<Index> indexes = new ArrayList<Index>();
		// Get event collection
		DBCollection eventCollection = this.getEventCollection();

		List<DBObject> mongoDbIndexes = eventCollection.getIndexInfo();
		for (DBObject dbObject : mongoDbIndexes) {
			indexes.add(this.toIndex(dbObject));
		}
		return indexes;
	}

	@Override
	public void ensureIndex(Index index) {
		// Get event collection
		DBCollection eventCollection = this.getEventCollection();

		// Get mongo keys and options
		DBObject keys = this.getIndexKeys(index);
		DBObject options = this.getIndexOptions(keys, index);

		// Ensure index
		eventCollection.ensureIndex(keys, options);
	}

	@Override
	public void dropIndex(Index index) {
		// Get event collection
		DBCollection eventCollection = this.getEventCollection();

		// Get mongo keys and options
		DBObject keys = this.getIndexKeys(index);

		// Drop index
		eventCollection.dropIndex(keys);
	}

	@Override
	public DatabaseInformation getDatabaseInformation() {
		DB db = this.mongoTemplate.getDb();
		CommandResult stats = db.getStats();
		DatabaseInformation databaseInformation = new DatabaseInformation();
		databaseInformation.setName(stats.getString("db"));
		databaseInformation.setDataSize(stats.getLong("dataSize"));
		databaseInformation.setFileSize(stats.getLong("fileSize"));
		databaseInformation.setIndexSize(stats.getLong("indexSize"));
		databaseInformation.setStorageSize(stats.getLong("storageSize"));
		databaseInformation.setObjects(stats.getLong("objects"));
		return databaseInformation;
	}

	protected DBObject getIndexKeys(Index index) {
		DBObject mondoIndexKeys = new BasicDBObject();
		for (IndexKey indexKey : index.getKeys()) {
			mondoIndexKeys.put(indexKey.getName(), indexKey.getAscending() ? 1 : -1);
		}
		return mondoIndexKeys;
	}

	protected DBObject getIndexOptions(DBObject mongoKeys, Index index) {
		// Get event collection
		DBCollection eventCollection = this.getEventCollection();

		DBObject mondoIndex = new BasicDBObject();
		mondoIndex.put("name", DBCollection.genIndexName(mongoKeys));
		mondoIndex.put("ns", eventCollection.getFullName());
		if (index.isUnique()) {
			mondoIndex.put("unique", Boolean.TRUE);
		}
		if (index.isDropDuplicates()) {
			mondoIndex.put("dropDups", Boolean.TRUE);
		}
		return mondoIndex;
	}

	protected Index toIndex(DBObject mongoIndex) {
		Index index = new Index();

		// Set key and ascending
		Object obj = mongoIndex.get("key");
		if (obj instanceof Map<?, ?> && !((Map<?, ?>) obj).isEmpty()) {
			Map<?, ?> keys = (Map<?, ?>) obj;
			for (Entry<?, ?> entry : keys.entrySet()) {
				IndexKey indexKey = new IndexKey((String) entry.getKey(), "1".equals(entry.getValue().toString()));
				index.getKeys().add(indexKey);
			}
		}

		if (mongoIndex.containsField("dropDups")) {
			index.setDropDuplicates(Boolean.valueOf(mongoIndex.get("dropDups").toString()));
		}

		if (mongoIndex.containsField("unique")) {
			index.setUnique(Boolean.valueOf(mongoIndex.get("unique").toString()));
		}

		return index;
	}

	private DBCollection getEventCollection() {
		return this.mongoTemplate.getCollection(this.eventCollectionName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.eventCollectionName = this.mongoTemplate.getCollectionName(Event.class);
	}

}
