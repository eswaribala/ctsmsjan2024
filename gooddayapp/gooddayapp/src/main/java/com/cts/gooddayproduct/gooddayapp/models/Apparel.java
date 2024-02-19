package com.cts.gooddayproduct.gooddayapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Apparel")
@EqualsAndHashCode(callSuper = false)
public class Apparel extends Product{
	@Column(name="Material")
	@Enumerated(EnumType.STRING)
	private Material material;
	@Column(name="Size")
	@Enumerated(EnumType.STRING)
	private Size size;
}
