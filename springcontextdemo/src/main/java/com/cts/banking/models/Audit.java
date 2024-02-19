package com.cts.banking.models;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.banking.facades.LoggerV1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit {
	@Autowired
	private LoggerV1 logger;

}
