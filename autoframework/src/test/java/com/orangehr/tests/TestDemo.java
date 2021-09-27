package com.orangehr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo extends BaseTest {

	@Test
	public void test01() {
		createTest("test01");
		test.info("I am in the first method step");
		System.out.println("I am in test01");
		Assert.assertEquals("Lakshmi", "Lakshmi");
	}

	@Test
	public void test02() {
		createTest("test02");
		test.info("I am in the second method step");
		System.out.println("I am in test02");
		Assert.assertEquals("Lakshmi", "Lakshmi2");
	}

}
