package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtils {
	
	
	public static String getOOid() {

		  SimpleDateFormat simpleDateFormat;

		  simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		  Date date = new Date();

		  String str = simpleDateFormat.format(date);// ��ǰʱ��  

		  Random random = new Random();

		  int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// ��ȡ5λ�����    

		  return rannum + str;// ��ǰʱ�� +������ɵ���λ��

      }
}
