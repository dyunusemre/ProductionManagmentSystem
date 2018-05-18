package com.ubs.ubs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "Warehouse")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Warehouse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String city;
	private List<Inventory> inventory;
	public String getCity() {
		return city;
	} 
	public void setCity(String city) {
		this.city = city;
	}	
	
	public Warehouse() {
		inventory = new ArrayList<>();
	}
	public Warehouse(String name, String city) {
		this.name = name;
		this.city = city;
		inventory = new ArrayList<>();
	}
	
	public Warehouse(Warehouse w) {
		this.id = w.getId();
		this.name = w.getName();
		this.city = w.getCity();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "primaryKey.warehouse",
			cascade = CascadeType.ALL)
	
	public List<Inventory> getInventory() {
		return inventory;
	}
	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}
	public void addInventory(Inventory inventory) {
		this.inventory.add(inventory);
	}
}
