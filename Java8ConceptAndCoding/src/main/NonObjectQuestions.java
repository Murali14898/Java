package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
	//11. Count words in a sentence
	public NonObjectQuestions countWordsInSentence(String sentence) {
		long cnt = Arrays.stream(sentence.split(" ")).count();
		System.out.println("Number of words are : "+cnt);
		return this;
	}
	//12. Convert a list of string to single string
	public NonObjectQuestions listOfStringToSingleString(List<String> list) {
		String ans = list.stream().collect(Collectors.joining(" "));
		return this;
	}
	//13. Find the frequency of characters in a String
	public NonObjectQuestions frequencyOfCharacters(String s) {
		Map<Character,Long> frequencyMap = s.chars().mapToObj(c->(char)c)
				                    .collect(Collectors.groupingBy(ch->ch,Collectors.counting()));
		System.out.println(frequencyMap.toString());
		return this;
	}
	//14. Check if a list contains specific element
	public <T> NonObjectQuestions checkElementInList(List<T> list,T ele) {
		boolean check = list.stream().anyMatch(T->T.equals(ele));
		String ans = check == true?"Element Available":"Element not Available";
		System.out.println(ans);
		return this;
	}
	//15. Faltten a list of lists
	public  NonObjectQuestions flattenAlist(List<List<Integer>> list) {
		int sum = list.stream().flatMap(ele->ele.stream())
				                           .mapToInt(Integer::intValue)
				                           .sum();
		System.out.println(sum);
		return this;
	}
	//16. Find max and in min in a list
	public NonObjectQuestions findMaxAndMin(List<Integer> list) {
		int max = list.stream().max(Comparator.comparingInt(Integer::intValue)).orElse(Integer.MAX_VALUE);
		int min = list.stream().max(Comparator.comparingInt(Integer::intValue)).orElse(Integer.MIN_VALUE);
		System.out.println(max+" is max value "+min+" is min value");
		return this;
	}
	//17. Find number of Even and Odd in a list
	public NonObjectQuestions countNoOfEvenOdd(List<Integer> list) {
		long cntEven = list.stream().filter(num->num%2==0).count();
		long cntOdd = list.stream().filter(num->num%2==0).count();
		System.out.println(cntEven+" is even count "+cntOdd+" is odd count");
		return this;
	}
	//18. Find most frequent element in a List
	public NonObjectQuestions mostFrequentElement(List<Integer> list) {
		int frequentEle = list.stream()
				              .collect(Collectors.groupingBy(num->num,Collectors.counting()))
				              .entrySet()
				              .stream()
				              .max(Map.Entry.comparingByValue())
				              .map(Map.Entry::getKey)
				              .orElse(Integer.MIN_VALUE);
		System.out.println(frequentEle);
		return this;
	}
	//19. Find all Palindromic String in a list
	public NonObjectQuestions pallindromicStringList(List<String> list) {
		List<String> pallindromicList = list.stream()
				                            .filter(ele->ele.equals(new StringBuilder(ele).reverse().toString()))
				                            .collect(Collectors.toList());
		System.out.println(pallindromicList.toString());
		return this;
	}
	//20. Find elements starts with specific character
	public NonObjectQuestions wordStartsWithSpecificElement(List<String> list,Character c) {
		List<String> ans = list.stream()
				               .filter(ele->ele.startsWith(c.toString()))
				               .collect(Collectors.toList());
		System.out.println(ans.toString());
		return this;
	}
	//21. Partitationing list into two groups
	public NonObjectQuestions partitationList(List<Integer> list) {
		Map<Boolean,List<Integer>> partitationMap = list.stream()
				                                         .collect(Collectors.partitioningBy(num->num%2==0));
		System.out.println("Even list "+partitationMap.get(true).toString());
		System.out.println("Even list "+partitationMap.get(false).toString());
		return this;
	}
	//22. Merge two List
	public NonObjectQuestions mergerList(List<Integer> list,List<Integer> list1) {
		List<Integer> ans = Stream.concat(list.stream(), list1.stream()).collect(Collectors.toList());
		System.out.println(ans.toString());
		return this;
	}
	//23. Convert a map to List of Keys and Values
	public NonObjectQuestions convertMaptoListOfKeysValues(Map<String,Integer> map) {
		List<String> keysList = map.keySet().stream().collect(Collectors.toList());
		List<Integer> valueList = map.values().stream().collect(Collectors.toList());
		System.out.println(keysList.toString()+" .... "+valueList.toString());
		return this;
	}
	//24. Find Average of numbers
	public NonObjectQuestions averageOfListNumbers(List<Integer> list) {
		double average = list.stream().mapToInt(Integer::intValue)
				                   .average()
				                   .orElse(0);
		System.out.println("Average is "+average);
		return this;
	}
	//25. Find PrimeNumbers in a List
	public NonObjectQuestions primeNumbersInAList(List<Integer> list) {
		List<Integer> primeList = list.stream()
		                              .filter(PrimeNumber::isPrime)
		                              .collect(Collectors.toList());
		System.out.println(primeList.toString());
		return this;
		                      
	}
	//26. Remove Null value from a list
	public <T> NonObjectQuestions removeNullValueFromList(List<T> list) {
		   List<T> ans = list.stream()
				             .filter(Objects::nonNull)
				             .collect(Collectors.toList());
		   System.out.println(ans.toString());
		   return this;
	}
	//27. Count vowels and consonant in a string
	public NonObjectQuestions countVowelAndConsonants(String s) {
		Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U') ;
		long vowelCnt = s.chars().mapToObj(c->(char)c)
				                .filter(ele->set.contains(ele))
				                .count();
		long consonantCnt = s.chars().mapToObj(c->(char)c)
				                     .filter(ele->!set.contains(ele))
				                     .count();
		System.out.println("Vowel count is "+vowelCnt+" Consonant count is "+consonantCnt);
		return this;
	}
	//28.
}
