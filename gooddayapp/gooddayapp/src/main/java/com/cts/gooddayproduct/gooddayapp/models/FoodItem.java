package com.cts.gooddayproduct.gooddayapp.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="FoodItem")
public class FoodItem extends Product{
	@Column(name="Date_Of_Manufaturing")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dom;
	@Column(name="Date_Of_Expiry")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate doe;
	@Column(name="Vegetarian")
	@Enumerated(EnumType.STRING)
	private Vegetarian vegetarian;


}
