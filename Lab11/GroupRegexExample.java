package com.lab11.pratice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegexExample {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\w+(\\S+)(\\.*)");
		String text ="tôi học java";
		Matcher matcher = pattern.matcher(text);
		System.out.println(matcher.group(1));
		System.out.println(matcher.group(2));
	}

}
