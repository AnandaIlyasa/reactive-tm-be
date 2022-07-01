package com.ilyas.turingmachine;

import java.util.stream.IntStream;

import com.ilyas.turingmachine.TM.TuringMachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TuringMachineApplicationTests {

	@Autowired
	private TuringMachine additionTM;
	@Autowired
	private TuringMachineController controller;

	@Test
	void contextLoads() {
	}

	@Test
	void testIfTM_tapeMatch() {
		String input = "000c11111";
		additionTM.setTape(input);
		IntStream.range(0, input.length())
				.forEach(i -> Assertions.assertEquals(input.substring(i, i + 1), additionTM.getTape().get(i)));
	}

	@Test
	void testAdditionTuringMachine() {
		String input = "000c11111";
		Assertions.assertAll(() -> controller.getAdditionResult(input));
	}

}
