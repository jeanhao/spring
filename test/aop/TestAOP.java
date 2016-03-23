package test.aop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	
	@Before
	public void setup(){
//		
	}
	
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/aop/aop.xml");
		Target target = (Target) ac.getBean("target");
		target.speak(21);
	}
}
