package com.mvc.test;

import java.util.Arrays;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import com.mvc.model.User;

public class UnitilsTest {
	@Test
	public void test1(){
		User user1 = new User(2,"a","b");
		User user2 = new User(3,"a","b");
//		ReflectionAssert.assertReflectionEquals(user1, user2);//断言成功
//		ReflectionAssert.assertPropertyLenientEquals("id", 1, user1);
		ReflectionAssert.assertPropertyLenientEquals("id", Arrays.asList(null, 2), Arrays.asList(user1,user2));//true
		ReflectionAssert.assertPropertyLenientEquals("id", Arrays.asList(3), Arrays.asList(user1,user2));//junit.framework.AssertionFailedError: Expected: [3], actual: [2, 3]
		ReflectionAssert.assertPropertyLenientEquals("id", Arrays.asList(3,2), Arrays.asList(user1,user2));//true
		ReflectionAssert.assertPropertyLenientEquals("id", Arrays.asList(3,4), Arrays.asList(user1,user2));//junit.framework.AssertionFailedError: Expected: [3, 4], actual: [2, 3]

	}
}
