package myproject.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test2 {

	public static void main(String args[]) {
		String strSentence = "HI EPAM bYe EPAM goodbye EPAM welcome ePAM Hi There epAM BYE bye EPaM";
		List<String> strList = Arrays.asList(strSentence.split(" "));


		Map<String, Integer> frequencyMap1 = strList.stream().map(String::toLowerCase)
				.collect(Collectors.toMap(w->w,w->1, Integer::sum));
		System.out.println("Word Frequency - .collect(Collectors.toMap(w->w,w->1, Integer::sum))) : "+frequencyMap1);

		
		Map<String, Integer> frequencyMap2 = strList.stream().map(String::toLowerCase)
				.collect(Collectors.toConcurrentMap(w->w,w->1, Integer::sum));
		System.out.println("Word Frequency - .collect(Collectors.toConcurrentMap(w->w,w->1, Integer::sum)) : "+frequencyMap2);

		
		Map<String, Long> frequencyMap3 = strList.stream().map(String::toLowerCase)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Word Frequency - .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) : "+frequencyMap3);
		
		Map<String, Integer> frequencyMap4 = strList.stream().map(String::toLowerCase)
				  .collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(v->1)));
		System.out.println("Word Frequency - .collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(v->1))): "+frequencyMap4);
		
		Map<String, Long> frequencyMap5 = strList.stream().map(String::toLowerCase)
				  .collect(Collectors.groupingByConcurrent(Function.identity(),Collectors.counting()));
		System.out.println("Word Frequency - .collect(Collectors.groupingByConcurrent(Function.identity(),Collectors.counting())): "+frequencyMap5);
		
		
		Map<String, Integer> frequencyMap6 = new HashMap<>();

		strList.stream().map(String::toLowerCase).forEach(word ->
		frequencyMap6.merge(word, 1, (v, newV) -> v + newV)
		);

		System.out.println("Word Frequency - strList.stream().map(String::toLowerCase).forEach(word ->\r\n"
				+ "		frequencyMap6.merge(word, 1, (v, newV) -> v + newV)\r\n"
				+ "		): "+frequencyMap6);
		
		Map<String, Integer> frequencyMap7 = new HashMap<>();

		strList.stream().map(String::toLowerCase).forEach(word ->
		frequencyMap7.compute(word,(k, v) -> v !=null ? v+1:1));

		System.out.println("Word Frequency - strList.stream().map(String::toLowerCase).forEach(word ->\r\n"
				+ "		frequencyMap7.compute(word,(k, v) -> v !=null ? v+1:1)): "+frequencyMap7);
		

		Map<String, Integer> frequencyMap8 = strList.stream().map(String::toLowerCase)
				  .collect(Collectors.groupingBy(Function.identity(),Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
		System.out.println("Word Frequency - .collect(Collectors.groupingBy(Function.identity(),Collectors.collectingAndThen(Collectors.counting(),Long::intValue))): "+frequencyMap5);
		
		
		
	}
}
