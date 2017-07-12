package com.rev.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "RT_CARS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class Car {
	
	@Id
	@Column(name = "C_ID")
	@SequenceGenerator(name = "CARS_ID_SEQ", sequenceName = "CARS_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARS_ID_SEQ")
	private int id;
	@Column(name = "C_NAME")
	private String carName;
	@Column(name = "C_MIN_LEVEL")	
	private String minLevel;
	@Column(name = "C_PRICE")
	private double price;
	@Column(name = "C_TOP_SPEED")
	private double topSpeed;
	@Column(name = "C_ACCELERATION")
	private double acceleration;
	@Column(name = "C_HANDLING")
	private double handling;
	
	
	public Car(){
		
	}
	public Car(String carName, String minLevel, double price, double topSpeed, double acceleration, double handling) {
		super();
		this.carName = carName;
		this.minLevel = minLevel;
		this.price = price;
		this.topSpeed = topSpeed;
		this.acceleration = acceleration;
		this.handling = handling;
	}
	public Car(int id, String carName, String minLevel, double price, double topSpeed, double acceleration,
			double handling) {
		super();
		this.id = id;
		this.carName = carName;
		this.minLevel = minLevel;
		this.price = price;
		this.topSpeed = topSpeed;
		this.acceleration = acceleration;
		this.handling = handling;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(String minLevel) {
		this.minLevel = minLevel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(acceleration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		temp = Double.doubleToLongBits(handling);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((minLevel == null) ? 0 : minLevel.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(topSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (Double.doubleToLongBits(acceleration) != Double.doubleToLongBits(other.acceleration))
			return false;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		if (Double.doubleToLongBits(handling) != Double.doubleToLongBits(other.handling))
			return false;
		if (id != other.id)
			return false;
		if (minLevel == null) {
			if (other.minLevel != null)
				return false;
		} else if (!minLevel.equals(other.minLevel))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(topSpeed) != Double.doubleToLongBits(other.topSpeed))
			return false;
		return true;
	}
}
