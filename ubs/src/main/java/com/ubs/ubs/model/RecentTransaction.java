package com.ubs.ubs.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Recent_Transactions")
public class RecentTransaction {
	@Id
	String id;
	@NotNull
	@Column(name = "t_id")
	int t_id;
	public RecentTransaction(String id, int t_id) {
		this.setId(id);
		this.setT_id(t_id);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	
}
