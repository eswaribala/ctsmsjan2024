package com.cts.gooddayproduct.gooddayapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Electronics")
@EqualsAndHashCode(callSuper = false)
public class Electronics extends Product{
    @Column(name="Warranty")
	private int warranty;
}
