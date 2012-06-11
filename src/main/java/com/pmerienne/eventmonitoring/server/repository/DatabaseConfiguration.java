package com.pmerienne.eventmonitoring.server.repository;

import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.administration.Index;

public interface DatabaseConfiguration {

	List<Index> getIndexes();

	void ensureIndex(Index index);

	void dropIndex(Index index);
}
