package test;

import org.junit.Test;

import com.yc.tool.MD5;


public class Test2 {
	@Test
	public void test1(){
		String plaintext = "zenghao9";
		Integer length = plaintext.length();
		String hashText = plaintext.substring(length / 2 , length) + "hash" + plaintext.substring(0 ,length/2  );
		String md5Text = MD5.GetMD5Code(hashText);
		System.out.println(md5Text);
	}
	
}
