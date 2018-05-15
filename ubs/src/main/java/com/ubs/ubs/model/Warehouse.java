package com.ubs.ubs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(name = "name")
	private String name;
	@NotNull
	@Column(name = "city")
	private String city;
	
	@ManyToMany( 
        	 cascade = {
               CascadeType.ALL
            },
            mappedBy = "warehouses" )
	private List<Product> products = new ArrayList<Product>();
	
	public Warehouse() {
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
