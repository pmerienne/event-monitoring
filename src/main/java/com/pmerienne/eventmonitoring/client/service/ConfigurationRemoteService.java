package com.pmerienne.eventmonitoring.client.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.pmerienne.eventmonitoring.shared.model.administration.Index;

@Path("configuration")
public interface ConfigurationRemoteService extends RestService {

	@GET
	@Path("getIndexes")
	void getIndexes(MethodCallback<List<Index>> callback);

	@POST
	@Path("createIndex")
	void createIndex(Index index, MethodCallback<Void> callback);

	@POST
	@Path("dropIndex")
	void dropIndex(Index index, MethodCallback<Void> callback);
}
