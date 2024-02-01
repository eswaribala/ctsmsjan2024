package com.cts.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

	private String branchName;
	private String ifscCode;
	private long postalCode;
}
