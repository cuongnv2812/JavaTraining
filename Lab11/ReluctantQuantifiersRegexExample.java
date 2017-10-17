package com.lab11.pratice;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReluctantQuantifiersRegexExample {

	public static void main(String[] args) {
		String text="xxxxjavaxxxxxxjava 12";
		Pattern pattern = Pattern.compile(".*?va",Pattern.UNICODE_CHARACTER_CLASS);
		Matcher matcher = pattern.matcher(text);
		System.out.println(text.substring(matcher.start(), matcher.end()));
		System.out.println("Reluctan----->"+ matcher.find(matcher.end()));
		System.out.println(text.substring(matcher.start(),matcher.end()));
		
	}

}
