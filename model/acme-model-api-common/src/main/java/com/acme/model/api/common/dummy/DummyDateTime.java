package com.acme.model.api.common.dummy;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DummyDateTime {

	private DummyDateTime() {
		throw new IllegalStateException("DummyDateTime");
	}

	public static final ZoneId ZONE_ID = ZoneId.systemDefault();
	public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.parse("2020-01-01 12:00",
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

	public static Date getDate() {
		return Date.from(LOCAL_DATE_TIME.atZone(ZONE_ID).toInstant());
	}

	public static Date getFutureDate() {
		return Date.from(LOCAL_DATE_TIME.plusDays(1).atZone(ZONE_ID).toInstant());
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZONE_ID).toLocalDateTime();
	}
}
