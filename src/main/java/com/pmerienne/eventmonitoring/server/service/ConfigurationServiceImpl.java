package com.pmerienne.eventmonitoring.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmerienne.eventmonitoring.server.repository.DatabaseConfiguration;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;

@Service("configurationService")
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	private DatabaseConfiguration databaseConfiguration;

	@Override
	public List<Index> getIndexes() {
		return this.databaseConfiguration.getIndexes();
	}

	@Override
	public void ensureIndex(Index index) {
		this.databaseConfiguration.ensureIndex(index);
	}

	@Override
	public void dropIndex(Index index) {
		this.databaseConfiguration.dropIndex(index);
	}

	@Override
	public DatabaseInformation getDatabaseInformation() {
		return this.databaseConfiguration.getDatabaseInformation();
	}

}
