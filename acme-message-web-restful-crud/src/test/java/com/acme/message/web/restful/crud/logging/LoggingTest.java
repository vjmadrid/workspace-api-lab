package com.acme.message.web.restful.crud.logging;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.web.restful.crud.controller.UserMessageNavigationController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggingTest {

	public static final String METHOD_NAME = "testMehtod";

	private ByteArrayOutputStream outContent;

	private PrintStream originalOut = System.out;
	
	@Autowired
	private UserMessageNavigationController userMessageNavigationController;

	@Before
	public final void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void whenCallAnyMethod_thenPrintLogs() throws Exception {
		userMessageNavigationController.userMessages();

		assertThat(outContent.toString(), containsString("Navigation UserMessages..."));
	}

	

}
