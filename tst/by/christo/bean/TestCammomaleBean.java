package by.christo.bean;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestCammomaleBean {

	private int min = 6;

	@Test
	public void TestCammomalePetalsCountGreaterMin() {

		Chamomile cammomile = new Chamomile();
		int realCount = cammomile.getPetalsNum();
		if (realCount < min) {
			fail("petals count less than min");
		}
	}
}
