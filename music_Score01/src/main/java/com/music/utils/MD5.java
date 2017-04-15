package com.music.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.music.utils.exception.SpeedException;

public class MD5 {
	
	public static String getMD5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new SpeedException("MD5加密出现错误");
		}
	} 

}
