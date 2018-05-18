package com.ubs.ubs.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Embeddable
public class InventoryId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Product product;
	@JsonIgnore
	private Warehouse warehouse;
	
	public InventoryId() {
	
	}
	
	public InventoryId(Product p, Warehouse w) {
		this.product = p;
		this.warehouse = w;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
}
