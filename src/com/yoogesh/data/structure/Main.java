package com.yoogesh.data.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args){

		String s="for";
		String s1 = "orf";
		
		char[] ch = s.toCharArray();
		char[] ch1 = s1.toCharArray();
		Arrays.sort(ch);
		Arrays.sort(ch1);
		
		System.out.println(Arrays.equals(ch, ch1));
	}

}
