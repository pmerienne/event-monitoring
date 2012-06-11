package com.pmerienne.eventmonitoring.client.utils;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.TimeData;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

public class TimeDataFetcher {

	public static List<TimeData> fetchDatas(TimeSerieResults results) {
		List<TimeData> fetchedData = results.getData();

		// Iterate over all possible interval to add missing value as zeros
		Date from = results.getRequest().getFrom();
		Date to = results.getRequest().getTo();
		Long interval = results.getRequest().getConfiguration().getInterval();
		Date current = from;
		while (current.before(to)) {
			if (!TimeDataFetcher.containsDate(fetchedData, current)) {
				fetchedData.add(new TimeData(current, 0.0));
			}
			current = new Date(current.getTime() + interval);
		}

		// Re order data
		Collections.sort(fetchedData);
		return fetchedData;
	}

	private static boolean containsDate(List<TimeData> data, Date time) {
		boolean contains = false;
		Iterator<TimeData> iterator = data.iterator();
		TimeData actualData = null;

		while (iterator.hasNext() && !contains) {
			actualData = iterator.next();
			contains = actualData.getDate().equals(time);
		}

		return contains;
	}
}
