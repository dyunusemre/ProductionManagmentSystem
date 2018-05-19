package com.ubs.ubs.model;

import javax.persistence.*;

@Entity
@Table(name = "Transfer_View")
public class TransferView {
	@Id
	private int id;
	private int in_w_id;
	private String in_wh_name;
	private int out_w_id;
	private String out_wh_name;
	private int p_id;
	private String p_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIn_w_id() {
		return in_w_id;
	}
	public void setIn_w_id(int in_w_id) {
		this.in_w_id = in_w_id;
	}
	public String getIn_wh_name() {
		return in_wh_name;
	}
	public void setIn_wh_name(String in_wh_name) {
		this.in_wh_name = in_wh_name;
	}
	public int getOut_w_id() {
		return out_w_id;
	}
	public void setOut_w_id(int out_w_id) {
		this.out_w_id = out_w_id;
	}
	public String getOut_wh_name() {
		return out_wh_name;
	}
	public void setOut_wh_name(String out_wh_name) {
		this.out_wh_name = out_wh_name;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private int qty;
	private String type;
}
