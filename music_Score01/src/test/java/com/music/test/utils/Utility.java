package com.music.test.utils;

import com.music.utils.authority.Authority;

public class Utility {
	@Authority(value="sys:sss",url="张三")
	public String work(){
		return "ok";
	}

}
