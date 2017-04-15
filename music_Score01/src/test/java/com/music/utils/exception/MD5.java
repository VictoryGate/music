package com.music.utils.exception;

import org.junit.Test;

public class MD5 {
	@Test
	public void testMD5(){
		com.music.utils.MD5 md5  = new com.music.utils.MD5();
		String str="123456";
		String md5Str =md5.getMD5(str);
		System.out.println(md5Str);
	}
}
