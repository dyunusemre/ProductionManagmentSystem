package com.ubs.ubs.model;

import javax.persistence.*;

@Entity
@Table(name = "`Cancel`")
public class Cancel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "t_id")
	private int transactionId;
	public Cancel() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
}
