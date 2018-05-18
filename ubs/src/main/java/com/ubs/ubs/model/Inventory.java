package com.ubs.ubs.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Inventory")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.product",
						joinColumns = @JoinColumn(
							     name = "p_id", referencedColumnName = "id")),
	@AssociationOverride(name = "primaryKey.warehouse",
	        			joinColumns = @JoinColumn(
	        					name = "w_id", referencedColumnName = "id"))
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="primaryKey")
public class Inventory implements Serializable{
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private InventoryId primaryKey = new InventoryId();
	public int qty;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	
	public Inventory(InventoryId pk, int qty) {
		this.primaryKey = pk;
		this.qty = qty;
	}
	
	@EmbeddedId
	public InventoryId getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(InventoryId primaryKey) {
		this.primaryKey = primaryKey;
	}
	@Transient
	public Product getProduct() {
		return getPrimaryKey().getProduct();
	}
	public void setProduct(Product product) {
		getPrimaryKey().setProduct(product);
	}
	@Transient
	public Warehouse getWarehouse() {
		return getPrimaryKey().getWarehouse();
	}
	public void setWarehouse(Warehouse warehouse) {
		getPrimaryKey().setWarehouse(warehouse);
	}
	@Column(name = "qty")
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Boolean decreaseQty(int x) {
		if(x<=this.qty) {
			this.setQty(this.qty-x);
			return true;
		}
		else
			return false;
	}
	public void increaseQty(int x) {
		this.setQty(this.qty + x);
	}
}
