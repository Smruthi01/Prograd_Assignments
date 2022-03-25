package Measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class testingMeasure {

	@Test
	public void test() {
		assertEquals("1000",UnitMeasure.ConvertUnit("g",1.0));
	}

}
