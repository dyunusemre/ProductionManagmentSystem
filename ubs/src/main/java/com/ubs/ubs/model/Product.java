package com.ubs.ubs.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@ManyToMany( fetch = FetchType.LAZY,
		     cascade = { 
		    		 CascadeType.PERSIST,
		    		 CascadeType.MERGE
		     })
	@JoinTable( name = "Inventory",
				joinColumns  = @JoinColumn ( name = "p_id" ),
				inverseJoinColumns = { @JoinColumn( name = "w_id ")} )
	private Set<Warehouse> warehouses = new HashSet<Warehouse>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Warehouse> getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(Set<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}
	
}
