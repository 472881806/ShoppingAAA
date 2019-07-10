package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtils {
	
	
	public static String getOOid() {

		  SimpleDateFormat simpleDateFormat;

		  simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		  Date date = new Date();

		  String str = simpleDateFormat.format(date);// 当前时间  

		  Random random = new Random();

		  int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数    

		  return rannum + str;// 当前时间 +随机生成的五位数

      }
}
