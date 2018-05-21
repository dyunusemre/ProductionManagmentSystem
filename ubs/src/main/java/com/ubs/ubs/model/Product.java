package com.ubs.ubs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Product")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	@JsonIgnore
	private List<Inventory> inventory;
	
	public Product() {
		inventory = new ArrayList<>();
	}
	public Product(String name) {
		this.name = name;
		inventory = new ArrayList<>();
	}
	public Product(Product p) {
		this.id = p.getId();
		this.name = p.getName();
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
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "primaryKey.product",
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
