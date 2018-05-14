package com.ubs.ubs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany( fetch = FetchType.LAZY,
		     cascade = { 
		    		 CascadeType.PERSIST,
		    		 CascadeType.MERGE
		     })
	@JoinTable( name = "Inventory",
				joinColumns  = @JoinColumn ( name = "p_id" ),
				inverseJoinColumns = { @JoinColumn( name = "w_id ")} )
	private List<Warehouse> warehouses = new ArrayList<Warehouse>();
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
	public List<Warehouse> getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}
	
}
