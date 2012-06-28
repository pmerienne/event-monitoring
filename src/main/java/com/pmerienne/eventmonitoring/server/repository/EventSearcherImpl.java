package com.pmerienne.eventmonitoring.server.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pmerienne.eventmonitoring.server.repository.utils.CriteriaBuilder;
import com.pmerienne.eventmonitoring.server.repository.utils.MapReduceHelper;
import com.pmerienne.eventmonitoring.server.repository.utils.MapReduceHelper.ValueObject;
import com.pmerienne.eventmonitoring.shared.model.PieData;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.TimeData;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.PieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.PieResults;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest.SortedField;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

@Repository
public class EventSearcherImpl implements EventSearcher {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private CriteriaBuilder criteriaBuilder;

	@Autowired
	private MapReduceHelper mapReduceHelper;

	@Override
	public TimeSerieResults search(TimeSerieRequest request) {
		TimeSerieResults serieResults = new TimeSerieResults(request);

		// Create query
		Criteria criteria = this.criteriaBuilder.buildCriteria(request.getConfiguration().getCriteriaQuery());
		Criteria dateCriteria = where("date").gt(request.getFrom()).lt(request.getTo());
		Query query = Query.query(new Criteria().andOperator(dateCriteria, criteria));

		// Create map/reduce/finalize functions
		SerieConfiguration configuration = request.getConfiguration();
		String mapFunction = this.mapReduceHelper.getMapFunctionForDateAggration(configuration);
		String reduceFunction = this.mapReduceHelper.getReduceFunction(configuration);
		String finalizeFunction = this.mapReduceHelper.getFinalizeFunction(configuration);

		// Create map reduce options
		MapReduceOptions options = MapReduceOptions.options().outputTypeInline().finalizeFunction(finalizeFunction);

		// Query mongodb database
		MapReduceResults<ValueObject> results = this.mongoTemplate.mapReduce(query, "event", mapFunction, reduceFunction, options, ValueObject.class);

		// Add result to the results
		for (ValueObject valueObject : results) {
			TimeData timeData = new TimeData(new Date(valueObject.getTimestamp()), valueObject.getValue());
			serieResults.addData(timeData);
		}
		return serieResults;
	}

	@Override
	public SearchResults search(SearchRequest request) {
		SearchResults searchResults = new SearchResults(request);

		Long current = new Date().getTime();
		// Create query object
		Criteria criteria = this.criteriaBuilder.buildCriteria(request.getTableConfiguration().getCriteria());
		Criteria dateCriteria = where("date").gt(new Date(current - request.getTableConfiguration().getTimeRange()));
		Query query = Query.query(new Criteria().andOperator(dateCriteria, criteria));

		// Count total results if needed
		if (request.getNeedTotalCount()) {
			Long totalCount = this.mongoTemplate.count(query, Event.class);
			searchResults.setTotalCount(totalCount);
		}
		// Sort
		for (SortedField sortedField : request.getSortedFields()) {
			Order order = sortedField.isAscending() ? Order.ASCENDING : Order.DESCENDING;
			query.sort().on(sortedField.getField(), order);
		}

		// Start and end index
		query.skip(request.getStart());
		query.limit(request.getEnd() - request.getStart());

		// Get ranged results
		List<Event> events = this.mongoTemplate.find(query, Event.class);
		searchResults.setEvents(events);

		return searchResults;
	}

	@Override
	public PieResults search(PieRequest request) {
		PieResults pieResults = new PieResults(request);

		// Create query
		Criteria criteria = this.criteriaBuilder.buildCriteria(request.getConfiguration().getCriteriaQuery());
		Criteria dateCriteria = where("date").gt(request.getFrom()).lt(request.getTo());
		Query query = Query.query(new Criteria().andOperator(dateCriteria, criteria));

		// Create map/reduce/finalize functions
		SerieConfiguration configuration = request.getConfiguration();
		String mapFunction = this.mapReduceHelper.getMapFunctionForMath(configuration);
		String reduceFunction = this.mapReduceHelper.getReduceFunction(configuration);
		String finalizeFunction = this.mapReduceHelper.getFinalizeFunction(configuration);

		// Create map reduce options
		MapReduceOptions options = MapReduceOptions.options().outputTypeInline().finalizeFunction(finalizeFunction);

		// Query mongodb database
		MapReduceResults<ValueObject> results = this.mongoTemplate.mapReduce(query, "event", mapFunction, reduceFunction, options, ValueObject.class);

		// Add result to the results
		for (ValueObject valueObject : results) {
			PieData pieData = new PieData(configuration.getName(), valueObject.getValue());
			pieResults.setData(pieData);
		}
		return pieResults;
	}
}