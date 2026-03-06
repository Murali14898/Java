package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class NonObjectQuestions {
	//1. Reverse a List using Stream
	public NonObjectQuestions reverseAList(List<Integer> list) {
		list.stream().sorted(Comparator.reverseOrder())
				     .forEach(num->System.out.print(num+" "));
		System.out.println();
		return this;
	}
	//2. Find first non repeat character in a String
	public NonObjectQuestions firstNonRepeatCharacter(String s) {
		char ans = s.chars().mapToObj(c->(char)c)
		         .collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()))
		         .entrySet()
		         .stream()
		         .filter(entry->entry.getValue()==1)
		         .map(Map.Entry::getKey)
		         .findFirst()
		         .orElse('0');
		System.out.println(ans);
		return this;
	}
	//3. Find Duplicate in a List
	public NonObjectQuestions findDuplicatesInAList(List<Integer> list) {
		List<Integer> ans = list.stream()
				                .collect(Collectors.groupingBy(num->num,Collectors.counting()))
				                .entrySet()
				                .stream()
				                .filter(entry->entry.getValue()>1)
				                .map(Map.Entry::getKey)
				                .collect(Collectors.toList());
		System.out.println(ans.toString());
		return this;
	}
	//4. Convert a list of String toUpperCase
	public NonObjectQuestions convertToUpperCase(List<String> list) {
		List<String> ans = list.stream()
				               .map(String::toUpperCase)
				               .collect(Collectors.toList());
		System.out.println(ans.toString());
		return this;
	}
	//5. Find second heighest number in an Array
	public NonObjectQuestions secondHeighestNumber(int[] arr) {
		int ans = Arrays.stream(arr).mapToObj(num->num)
				        .sorted(Comparator.reverseOrder())
				        .distinct()
				        .skip(1)
				        .findFirst()
				        .orElse(0);
		System.out.println(ans);
		return this;
	}
	//6. Sum of Even Numbers in A list
	public NonObjectQuestions sumOfEvenNumbers(List<Integer> list) {
		int sum = list.stream()
				      .filter(num->num%2==0)
				      .mapToInt(num->num)
				      .sum();
		System.out.println(sum);
		return this;
	}
	//7. Check if a list contains only even numbers
	public NonObjectQuestions checkOnlyEven(List<Integer> list) {
		boolean ans = list.stream()
				          .allMatch(num->num%2==0);
		System.out.println(ans);
		return this;
	}
	//8. Find Largest String in a List
	public NonObjectQuestions largetString(List<Integer> list) {
//		String largestString =list.stream()
//                                  .max(Comparator.comparingInt(String::length))
//                                  .orElse(null);
//		System.out.println();	                   
		return this;
				
	}
	//9. Sort a map by value
	public NonObjectQuestions sortAMapByValue(Map<String,Integer> map) {
		
		Map<String,Integer> ans =map.entrySet().stream()
		                       .sorted(Map.Entry.comparingByValue())
		                       .collect(Collectors.toMap(
		                               Map.Entry::getKey,
		                               Map.Entry::getValue,
		                               (e1, e2) -> e1,
		                               LinkedHashMap::new
		                           ));
		System.out.println(ans.toString());
		return this;
	}
	//10. Remove duplicates from a list
	public NonObjectQuestions removeDuplicates(List<Integer> list) {
		List<Integer> ans = list.stream()
				                .distinct()
				                .collect(Collectors.toList());
		System.out.println(ans.toString());
		return this;
	}
	
}
