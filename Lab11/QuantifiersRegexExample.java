package com.lab11.pratice;

import java.lang.Character.UnicodeBlock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifiersRegexExample {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("t?\\S+ (\\S+)(.*)");
		String text ="to hoc java";
		Matcher matcher = pattern.matcher(text);
		System.out.println(text + "---->" + matcher.matches());
		
		text = "cau hoc java";
		matcher=pattern.matcher(text);
		System.out.println(text + "---->" + matcher.matches());
		
		text="toi hoc java";
		matcher=pattern.matcher(text);
		System.out.println(text + "---->" + matcher.matches());
	}

}
