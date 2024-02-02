package com.cts.banking.facades;

import java.util.Comparator;

import com.cts.banking.models.Individual;

public class IndividualSorter implements Comparator<Individual> {

	@Override
	public int compare(Individual o1, Individual o2) {
		// TODO Auto-generated method stub
		return o1.getDob().compareTo(o2.getDob());
	}

}
