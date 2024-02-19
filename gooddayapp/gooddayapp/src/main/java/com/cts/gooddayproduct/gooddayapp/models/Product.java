package com.cts.gooddayproduct.gooddayapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Item_Code")
	private int itemCode;
	@Column(name="Item_Name",length = 50, nullable = false)
	private String itemName;
	@Column(name="Unit_Price")
	private int unitPrice;
	@Column(name="Qty")
	private int qty;
	

}
