package com.ubs.ubs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Warehouse implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(name = "name")
	private String name;
	@NotNull
	@Column(name = "city")
	private String city;
	
	@OneToMany( 
        	 cascade = {
               CascadeType.ALL
            },
            mappedBy = "product" )
	private Set<Inventory> inventory = new HashSet<Inventory>();
	
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
	public Set<Inventory> getInventory() {
		return inventory;
	}
	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}
}
