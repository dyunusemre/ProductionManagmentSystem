package com.ubs.ubs.model;

import javax.persistence.*;

@Entity
@Table(name = "Transfer")
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "in_w_id")
	private int inWarehouseId;
	@Column(name = "out_w_id")
	private int outWarehouseId;
	@Column(name = "p_id")
	private int productId;
	@Column(name = "qty")
	private int qty;
	
	public Transfer() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInWarehouseId() {
		return inWarehouseId;
	}
	public void setInWarehouseId(int inWarehouseId) {
		this.inWarehouseId = inWarehouseId;
	}
	public int getOutWarehouseId() {
		return outWarehouseId;
	}
	public void setOutWarehouseId(int outWarehouseId) {
		this.outWarehouseId = outWarehouseId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
