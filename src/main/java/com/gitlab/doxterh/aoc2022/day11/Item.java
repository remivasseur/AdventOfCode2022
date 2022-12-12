package com.gitlab.doxterh.aoc2022.day11;

import java.math.BigInteger;

public class Item {
	private BigInteger worry;


	public void setWorry(BigInteger worry) {
		this.worry = worry;
	}

	public Item(BigInteger worry) {
		super();
		this.worry = worry;
	}

	public BigInteger getWorry() {
		return worry;
	}

	@Override
	public String toString() {
		return "" + worry;
	}
	
	
}
