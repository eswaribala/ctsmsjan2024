package com.cts.bankingretailapi.models;

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
@Table(name="CurrentAccount")
@EqualsAndHashCode(callSuper = false)
public class CurrentAccount extends Account{
	@Column(name="OD_Limit")
	private Long odLimit;

}
