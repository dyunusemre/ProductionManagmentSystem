package com.ubs.ubs.model;

import javax.persistence.*;

@Entity
@Table(name="Handle_Return")
public class Return {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "t_id")
	private int transactionId;
	@Column(name = "t_type")
	private String transactionType;
	
	
	public Return() {
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


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}	
	
}
