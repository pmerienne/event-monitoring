package com.pmerienne.eventmonitoring.server.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pmerienne.eventmonitoring.server.service.ConfigurationService;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;
import com.sun.jersey.api.core.InjectParam;

@Path("configuration")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class ConfigurationResource {

	@InjectParam
	private ConfigurationService configurationService;

	@GET
	@Path("getIndexes")
	public List<Index> getIndexes() {
		return this.configurationService.getIndexes();
	}

	@POST
	@Path("createIndex")
	public void createIndex(Index index) {
		this.configurationService.ensureIndex(index);
	}

	@POST
	@Path("dropIndex")
	public void dropIndex(Index index) {
		this.configurationService.dropIndex(index);
	}

	@GET
	@Path("getServerDetails")
	public DatabaseInformation getServerDetails() {
		return this.configurationService.getDatabaseInformation();
	}
}
