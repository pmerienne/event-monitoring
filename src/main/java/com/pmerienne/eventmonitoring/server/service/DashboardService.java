package com.pmerienne.eventmonitoring.server.service;

import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface DashboardService {

	Dashboard save(Dashboard dashboard);

	void delete(Dashboard dashBoard);

	Dashboard find(String id);

	List<Dashboard> findAll();
}
