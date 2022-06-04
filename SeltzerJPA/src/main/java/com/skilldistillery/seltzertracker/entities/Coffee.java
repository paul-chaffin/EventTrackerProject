package com.skilldistillery.seltzertracker.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Coffee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int ounces;
	
	private boolean creamer;
	
	@Column(name = "sugar_tbsp")
	private float sugarTbsp;
	
	@Column(name = "date_time")
	@CreationTimestamp
	private LocalDateTime dateTime;
	
	public Coffee() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOunces() {
		return ounces;
	}

	public void setOunces(int ounces) {
		this.ounces = ounces;
	}

	public boolean isCreamer() {
		return creamer;
	}

	public void setCreamer(boolean creamer) {
		this.creamer = creamer;
	}

	public float getSugarTbsp() {
		return sugarTbsp;
	}

	public void setSugarTbsp(float sugarTbsp) {
		this.sugarTbsp = sugarTbsp;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Coffee [id=" + id + ", ounces=" + ounces + ", creamer=" + creamer + ", sugarTbsp=" + sugarTbsp
				+ ", dateTime=" + dateTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coffee other = (Coffee) obj;
		return id == other.id;
	}

	
	
	
}
