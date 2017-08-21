package com.ads.bd2.agenda.modelo;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "latitudelongitude", schema="public")
//@Embeddable
public class LatitudeLongitude {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private double latitude;

	private double longitude;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public LatitudeLongitude() {
		
	}

}
