package com.ubs.ubs.model;

import java.io.Serializable;

import javax.persistence.Column;

public class idview implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "p_id", nullable = false)
    private int p_id;

    @Column(name = "w_id", nullable = false)
    
    private int w_id;
    public int getP_id() {
		return p_id;
	}
    public int getW_id() {
		return w_id;
	}
    public void setP_id(int p_id) {
		this.p_id = p_id;
	}
    public void setW_id(int w_id) {
		this.w_id = w_id;
	}
    
}
