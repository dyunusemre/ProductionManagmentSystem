package com.ubs.ubs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String city;
	
	@ManyToMany( fetch = FetchType.LAZY,
        	 cascade = {
               CascadeType.PERSIST,
               CascadeType.MERGE
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
