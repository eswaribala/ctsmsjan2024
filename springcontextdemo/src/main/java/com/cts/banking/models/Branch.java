package com.cts.banking.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Branch {

	private String branchName;
	private String ifscCode;
	private long postalCode;
}
