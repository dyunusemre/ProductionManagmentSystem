package com.ubs.ubs.model;

import javax.persistence.*;

@Entity
@Table(name = "Cancel")
public class Cancel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "t_id")
	private int transactionId;
	@Column(name = "t_type")
	private String transactionType;
	public Cancel() {
		// TODO Auto-generated constructor stub
	}	
	public Cancel(int t_id, String t_type) {
		this.setTransactionId(t_id);
		this.setTransactionType(t_type);
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
	public String getTableName(String str) {
		if(str.equals("goodin"))
			return "Good_In";
		else if(str.equals("goodout"))
			return "Good_Out";
		else if(str.equals("transfer"))
			return "Transfer";
		else if(str.equals("return"))
			return "Handle_Return";
		else if(str.equals("cancel"))
			return "Cancel";
		else 
			return "Null";
	}
	
}
