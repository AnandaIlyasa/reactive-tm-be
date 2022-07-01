package com.ilyas.turingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TuringMachineApplicationTests {

	@Autowired
	private TuringMachineController controller;

	@Test
	void contextLoads() {
	}

	@Test
	void testAdditionTuringMachine() {
		String input = "000c11111";
		Assertions.assertAll(() -> controller.getAdditionResult(input));
	}

}
