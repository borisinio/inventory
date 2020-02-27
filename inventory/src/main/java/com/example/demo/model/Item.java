package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private int inventoryCode;
	
	private int itemNo;
	
	private String name;
	
	private int amount;

	

	public int getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(int inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
