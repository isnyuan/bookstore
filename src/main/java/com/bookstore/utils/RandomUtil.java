package com.bookstore.utils;

/**
 * 功能描述: 生成一串随机数
 * @Author: lihuizong
 * @Date: 2020/9/20 14:03
 */
public class RandomUtil {
	
	/*
	 * @param count :需要产生随机数的个数
	 */
	public static String radmonkey(int count){
		StringBuffer sbf=new StringBuffer();
		for (int i = 0; i <count; i++) {
			int num=(int)(Math.random()*10);
			sbf.append(num);
		}
		
		return sbf.toString();
	}

}
