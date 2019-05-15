package com.ecomm_crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Item_Id")
    private long id;  
	@Column(name="Item_Name")
    private String iname;
	@Column(name="Item_Description")	
	private String desc;
	@Column(name="Item_Price")	
	private int price;
	@Column(name="Avaiable")	
	private String avail;
	@Column(name="Category_ID")	
	private int cid;
	public long getId() {
		return id;
	}
	public void setId(long id2) {
		this.id = id2;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

