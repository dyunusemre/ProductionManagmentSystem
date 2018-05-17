package com.ubs.ubs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Product")
public class Product implements Serializable{
	private int id;
	private String name;
	private Set<Inventory> inventory;
	
	public Product() {
		inventory = new HashSet<>();
	}
	public Product(String name) {
		this.name = name;
		inventory = new HashSet<>();
	}
	public void addWarehouse(Inventory inventory) {
		this.inventory.add(inventory);
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
	
	@OneToMany(mappedBy = "primaryKey.product",
			cascade = CascadeType.ALL)
	public Set<Inventory> getInventory() {
		return inventory;
	}
	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}
	public void addInventory(Inventory inventory) {
		this.inventory.add(inventory);
	}
	
	
	
}
