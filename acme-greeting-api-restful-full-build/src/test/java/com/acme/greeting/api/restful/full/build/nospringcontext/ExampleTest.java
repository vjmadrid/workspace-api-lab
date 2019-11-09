package com.acme.greeting.api.restful.full.build.nospringcontext;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class ExampleTest {

	private ArrayList<String> testList;
	
	@Before
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		testList.clear();
	}

	@Test
	public void whenAddElement_thenReturnSizeElementList() {
		testList.add("element 1");
		assertEquals(1, testList.size());
	}
	
	@Test
	public void whenEmptyList_thenReturnIsEmptyList() {
		assertTrue(testList.isEmpty());
	}

}