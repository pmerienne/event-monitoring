package com.pmerienne.eventmonitoring.server.service;

import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.administration.Index;

public interface ConfigurationService {

	List<Index> getIndexes();

	void ensureIndex(Index index);

	void dropIndex(Index index);
}
