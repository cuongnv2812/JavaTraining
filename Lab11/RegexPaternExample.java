package com.lab11.pratice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPaternExample {

	public static void main(String[] args) {
		Pattern pattern =Pattern.compile("\\d+");
		String text ="1 + 1 bang 2";
		Matcher matcher = pattern.matcher(text);
		System.out.println(matcher.find());
		System.out.println("Start= " + matcher.start() + " - end" + matcher.end());
		System.out.println("value="+ text.substring(matcher.start(), matcher.end()));
		
		
	}

}
