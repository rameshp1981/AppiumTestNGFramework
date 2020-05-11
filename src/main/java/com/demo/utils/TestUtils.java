package com.demo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {
	public static final long WAIT=10;
	
	public String getDateTime()
	{
		DateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		System.out.println(dateformat.format(date));
		return dateformat.format(date);
		
	}

}
