package com.pmerienne.eventmonitoring.client.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.pmerienne.eventmonitoring.shared.model.Dashboard;

@Path("dashboards/")
public interface DashboardRemoteService extends RestService {

	@POST
	@Path("save")
	void save(Dashboard dashboard, MethodCallback<Dashboard> callback);

	@POST
	@Path("delete")
	void delete(Dashboard dashBoard, MethodCallback<Void> callback);

	@GET
	@Path("find")
	void find(@QueryParam("id") String id, MethodCallback<Dashboard> callback);

	@GET
	@Path("findAll")
	void findAll(MethodCallback<List<Dashboard>> callback);
}
