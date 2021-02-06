package binary.coder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryCoderTest {

	@Test
	void test1() {
		int x = -2147483647;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test2() {
		int x = 12345678;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test3() {
		int x = -12345678;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test4() {
		int x = Integer.MAX_VALUE;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test5() {
		int x = Integer.MIN_VALUE;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test6() {
		int x = -894348935;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test7() {
		int x = -345765437;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test8() {
		int x = 930453490;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test9() {
		int x = 98765;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test10() {
		int x = -21876;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test11() {
		int x = -1;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test12() {
		int x = 1;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void test13() {
		int x = 0;
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void testPosRandom1() {
		int x = (int) (Math.random() * Integer.MAX_VALUE);
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void testPosRandom2() {
		int x = (int) (Math.random() * Integer.MAX_VALUE);
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void testPosRandom3() {
		int x = (int) (Math.random() * Integer.MAX_VALUE);
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void testNegRandom1() {
		int x = (int) (Math.random() * Integer.MIN_VALUE);
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void testNegRandom2() {
		int x = (int) (Math.random() * Integer.MIN_VALUE);
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	@Test
	void testNegRandom3() {
		int x = (int) (Math.random() * Integer.MIN_VALUE);
		assertEquals(x, BinaryCoder.map(binaryString(x)));
	}

	private String binaryString(int x) {
		String result = Integer.toBinaryString(x);
		while (result.length() < 32) {
			result = "0" + result;
		}
		return result;
	}

}