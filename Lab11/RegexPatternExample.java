package com.lab11.pratice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternExample {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\d+");
		String text="1+1 bang 21231-4";
		Matcher matcher = pattern.matcher(text);
		int start=0;
		int end;
		while(matcher.find(start)) {
			start = matcher.start();
			end = matcher.end();
			System.out.println("number: " + text.substring(start, end));
			start=end;
		}
	}

}
