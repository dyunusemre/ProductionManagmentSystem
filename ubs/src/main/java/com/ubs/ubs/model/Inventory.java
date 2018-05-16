package com.ubs.ubs.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
public class Inventory implements Serializable{
	private Product product;
	private Warehouse warehouse;
	@Column(name = "qty")
	private int qty;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "p_id")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Id
	@ManyToOne
	@JoinColumn(name = "w_id")
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
