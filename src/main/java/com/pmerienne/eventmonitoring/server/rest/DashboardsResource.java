package com.pmerienne.eventmonitoring.server.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.pmerienne.eventmonitoring.server.service.DashboardService;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.sun.jersey.api.core.InjectParam;

@Path("dashboards")
public class DashboardsResource {

	@InjectParam
	private DashboardService dashboardService;

	@POST
	@Path("save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Dashboard save(Dashboard dashboard) {
		return this.dashboardService.save(dashboard);
	}

	@POST
	@Path("delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public void delete(Dashboard dashBoard) {
		this.dashboardService.delete(dashBoard);
	}

	@GET
	@Path("find")
	@Produces({ MediaType.APPLICATION_JSON })
	public Dashboard find(@QueryParam("id") String id) {
		return this.dashboardService.find(id);
	}

	@GET
	@Path("findAll")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Dashboard> findAll() {
		return this.dashboardService.findAll();
	}
}
