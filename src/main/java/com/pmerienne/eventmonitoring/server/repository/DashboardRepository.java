package com.pmerienne.eventmonitoring.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface DashboardRepository extends MongoRepository<Dashboard, String> {

}
