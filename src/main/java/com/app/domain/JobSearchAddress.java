package com.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobSearchAddress {
	private String unit;
	private long maxJobDistance;
	private String longitude;
	private String latitude;

	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public long getMaxJobDistance() {
		return maxJobDistance;
	}
	public void setMaxJobDistance(long maxJobDistance) {
		this.maxJobDistance = maxJobDistance;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}
