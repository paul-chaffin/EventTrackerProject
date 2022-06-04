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
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date_time")
	@CreationTimestamp
	private LocalDateTime dateTime;
	
	private String brewer;
	
	private String style;
	
	@Column(name="style_2")
	private String styleTwo;
	
	private String name;
	
	private String origin;
	
	private float abv;
	
	private String purveyor;

	public Beer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getBrewer() {
		return brewer;
	}

	public void setBrewer(String brewer) {
		this.brewer = brewer;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleTwo() {
		return styleTwo;
	}

	public void setStyleTwo(String styleTwo) {
		this.styleTwo = styleTwo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public float getAbv() {
		return abv;
	}

	public void setAbv(float abv) {
		this.abv = abv;
	}

	public String getPurveyor() {
		return purveyor;
	}

	public void setPurveyor(String purveyor) {
		this.purveyor = purveyor;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", dateTime=" + dateTime + ", brewer=" + brewer + ", style=" + style + ", styleTwo="
				+ styleTwo + ", name=" + name + ", origin=" + origin + ", abv=" + abv + ", purveyor=" + purveyor + "]";
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
		Beer other = (Beer) obj;
		return id == other.id;
	}
	
	
	
	
}
