package main;

import java.util.stream.Collectors;

public class AnagramHelper {
	public static String sortedString(String s) {
		String ans = s.chars()
                      .mapToObj(c->String.valueOf((char)c))
                      .sorted()
                      .collect(Collectors.joining());
		
		return ans;
	}

}
