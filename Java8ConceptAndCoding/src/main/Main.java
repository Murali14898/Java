package main;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<Integer> list= List.of(2,6,1,9,5,7,4,3,11,10,2,9);
		List<String>  list1 = List.of("AbcDef","AgthjuiPo","bcAfeD");
		String s = "ABCBAD";
		int[] arr = {7,4,3,11,10,2};
		Map<String,Integer> map = Map.of("Ram",89,"Raj",76,"Raju",70,"Rahim",92);
		NonObjectQuestions nonObj = new NonObjectQuestions().reverseAList(list)
//				                                            .firstNonRepeatCharacter(s)
//				                                            .findDuplicatesInAList(list)
//				                                            .convertToUpperCase(list1)
//				                                            .secondHeighestNumber(arr)
//				                                            .sumOfEvenNumbers(list)
//				                                            .checkOnlyEven(list)
//				                                            .sortAMapByValue(map)
//				                                            .removeDuplicates(list)
//				                                            .primeNumbersInAList(list)
		                                                    .anagramsInList(list1);

	}

}
