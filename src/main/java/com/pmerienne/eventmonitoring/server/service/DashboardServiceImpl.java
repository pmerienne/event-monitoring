package com.pmerienne.eventmonitoring.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmerienne.eventmonitoring.server.repository.DashboardRepository;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

@Service("dashBoardService")
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;

	@Override
	public Dashboard save(Dashboard dashboard) {
		return this.dashboardRepository.save(dashboard);
	}

	@Override
	public void delete(Dashboard dashBoard) {
		this.dashboardRepository.delete(dashBoard);
	}

	@Override
	public Dashboard find(String id) {
		return this.dashboardRepository.findOne(id);
	}

	@Override
	public List<Dashboard> findAll() {
		return this.dashboardRepository.findAll();
	}
}
