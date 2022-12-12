package com.gitlab.doxterh.aoc2022.day11;

import java.math.BigInteger;

public class Operation {
	private final  String operande1;
	private final String operande2;
	private final char operator;
	
	public Operation(String operande1, String operande2, char operator) {
		super();
		this.operande1 = operande1;
		this.operande2 = operande2;
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "new = " + operande1 + " " + operator + " " + operande2;
	}

	public BigInteger execute(BigInteger worry) {
		//System.out.println("-> Avant operation.execute");
		final BigInteger oper1;
		final BigInteger oper2;
		
		if ("old".equals(operande1)) {
			oper1 = worry;
		} else {
			oper1 = new BigInteger(operande1);
		}
		
		if ("old".equals(operande2)) {
			oper2 = worry;
		} else {
			oper2 = new BigInteger(operande2);
		}
		
		BigInteger result = null;
		
		if (operator == '+') {
			result =   oper1.add(oper2);
		} else if (operator == '-') {
			result =   oper1.subtract(oper2);
		} else if (operator == '*') {
			result =   oper1.multiply(oper2);
		} 
		//System.out.println("-> Apres operation.execute");
		return result;
	}

	public boolean divisibleBy(long worry, int divisibleBy) {
		
		final long oper1;
		final long oper2;
		
		if ("old".equals(operande1)) {
			oper1 = worry;
		} else {
			oper1 = Long.parseLong(operande1);
		}
		
		if ("old".equals(operande2)) {
			oper2 = worry;
		} else {
			oper2 = Long.parseLong(operande2);
		}
		
		boolean result = false;
		if (operator == '+') {
			result =  (oper1 + oper2) % divisibleBy == 0;
			
			if (result) {
				//System.out.println("New way -> V : " + oper1 + " + " + oper2 + " divisible par " + divisibleBy);
			}
			else {
				//System.out.println("New way -> X : " + oper1 + " + " + oper2 + " divisible par " + divisibleBy);
			}
		} else if (operator == '-') {
			result =  (oper1 - oper2) % divisibleBy == 0 ;
			
			if (result) {
				//System.out.println("New way -> V : " + oper1 + " - " + oper2 + " divisible par " + divisibleBy);
			}
			else {
				//System.out.println("New way -> X : " + oper1 + " - " + oper2 + " divisible par " + divisibleBy);
			}
		} else if (operator == '*') {
			result =  oper1 % divisibleBy == 0 || oper2 % divisibleBy == 0;
			
			if (result) {
				//System.out.println("New way -> V : " + oper1 + " ou " + oper2 + " divisible par " + divisibleBy);
			}
			else {
				//System.out.println("New way -> X : " + oper1 + " ni " + oper2 + " divisible par " + divisibleBy);
			}
		}
		
		
		return result;
	}
	
	

}
