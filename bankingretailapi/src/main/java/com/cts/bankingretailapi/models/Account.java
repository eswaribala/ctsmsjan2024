package com.cts.bankingretailapi.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="Account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	@Id
	@Column(name="Account_No")
	protected long accountNo;
	@Column(name="Running_Total")
	protected long runningTotal;
	@Column(name="DOP")
	protected LocalDate dop;


}
