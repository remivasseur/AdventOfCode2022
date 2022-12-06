package com.gitlab.doxterh.aoc2022.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class Step1Test {

	@Test
	void shouldGetIndexLineNumber() {
		
		assertEquals(3,Step1.getIndexLineNumber(Data.TEST.split("\n")));
	}
	
	@Test
	void shouldGetColumnIndexForEachStack() {
		
		Map<Integer, Integer> expectedColumnsIndex = new HashMap<>();
		
		expectedColumnsIndex.put(1, 1);
		expectedColumnsIndex.put(2, 5);
		expectedColumnsIndex.put(3, 9);
		
		Map<Integer,Integer> columnsIndex = Step1.getMappedColumnIndex(Data.TEST.split("\n"));
		
		assertEquals(3, columnsIndex.size());
		
		assertEquals(1, columnsIndex.get(1));
		assertEquals(5, columnsIndex.get(2));
		assertEquals(9, columnsIndex.get(3));
	
	}
	
	@Test
	void shouldGetFirstStack() {
		Stack<Character>[] stacks = Step1.populateStack(Data.TEST.split("\n"));
		
		Stack<Character> firtStack = stacks[0];
		assertEquals(2, firtStack.size());
		
		assertEquals('N',firtStack.pop());
		assertEquals('Z',firtStack.pop());
		
	}

	@Test
	void shouldGetSecondStack() {
		Stack<Character>[] stacks = Step1.populateStack(Data.TEST.split("\n"));
		
		Stack<Character> secondStack = stacks[1];
		assertEquals(3, secondStack.size());
		
		assertEquals('D',secondStack.pop());
		assertEquals('C',secondStack.pop());
		assertEquals('M',secondStack.pop());
	}
	
	@Test
	void shouldGetThirdStack() {
		Stack<Character>[] stacks = Step1.populateStack(Data.TEST.split("\n"));
		
		Stack<Character> secondStack = stacks[2];
		assertEquals(1, secondStack.size());
		
		assertEquals('P',secondStack.pop());
	}

	@Test
	void shoudExtractValue() {
		
		int[] values = Step1.parseAction("move 1 from 2 to 1");
		
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(1, values[2]);
		
		int[] values2 = Step1.parseAction("move 3 from 1 to 3");
		
		assertEquals(3, values2[0]);
		assertEquals(1, values2[1]);
		assertEquals(3, values2[2]);
	}
	
	@Test
	void shouldApplyProcedureStep() {
		Stack<Character>[] stacks = new Stack[3];
		Stack<Character> stack1 = new Stack<>();
		stack1.push('Z');
		stack1.push('N');
		stacks[0] = stack1;
		
		Stack<Character> stack2 = new Stack<>();
		stack2.push('M');
		stack2.push('C');
		stack2.push('D');
		stacks[1] = stack2;
		
		Stack<Character> stack3 = new Stack<>();
		stack3.push('P');
		stacks[2] = stack3;
		
		Step1.applyProcedureStep(stacks, "move 1 from 2 to 1");
		
		assertEquals('D', stack1.pop());
		assertEquals('N', stack1.pop());
		assertEquals('Z', stack1.pop());
		
		assertEquals('C', stack2.pop());
		assertEquals('M', stack2.pop());
		
		assertEquals('P', stack3.pop());
	}
	
	@Test
	void shouldApplyProcedureStep2() {
		Stack<Character>[] stacks = new Stack[3];
		Stack<Character> stack1 = new Stack<>();
		stack1.push('Z');
		stack1.push('N');
		stack1.push('D');
		stacks[0] = stack1;
		
		Stack<Character> stack2 = new Stack<>();
		stack2.push('M');
		stack2.push('C');
		stacks[1] = stack2;
		
		Stack<Character> stack3 = new Stack<>();
		stack3.push('P');
		stacks[2] = stack3;
		
		Step2.applyProcedureStep(stacks, "move 3 from 1 to 3");
		
		assertTrue(stack1.isEmpty());
		
		assertEquals('C', stack2.pop());
		assertEquals('M', stack2.pop());
		
		assertEquals('Z', stack3.pop());
		assertEquals('N', stack3.pop());
		assertEquals('D', stack3.pop());
		assertEquals('P', stack3.pop());
	}
	
	@Test
	void shouldApplyCompleteProcedure() {
		Stack<Character>[] stacks = Step1.applyProcedure(Data.TEST.split("\n"));
		
		assertEquals('C', stacks[0].pop());
		assertEquals('M', stacks[1].pop());
		assertEquals('Z', stacks[2].pop());
		assertEquals('N', stacks[2].pop());
		assertEquals('D', stacks[2].pop());
		assertEquals('P', stacks[2].pop());
	}
	
	
	@Test
	void shouldGetTopElementOfEachStack() {
		assertEquals("CMZ", Step1.getTopElementOfEachStack(Data.TEST.split("\n")));
	}
	
}
