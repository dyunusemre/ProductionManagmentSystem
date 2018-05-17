package com.ubs.ubs.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.product",
	        joinColumns = @JoinColumn(
	        		foreignKey = @ForeignKey(name = "FK_p_id"), name = "p_id", referencedColumnName = "id")),
	@AssociationOverride(name = "primaryKey.warehouse",
	        joinColumns = @JoinColumn(
	        		foreignKey = @ForeignKey(name = "FK_w_id"), name = "w_id", referencedColumnName = "id"))
})
public class Inventory implements Serializable{
	private InventoryId primaryKey = new InventoryId();
	public int qty;
	
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
}
