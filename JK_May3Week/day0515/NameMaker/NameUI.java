package NameMaker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NameUI 

{
	private Scanner scanner;	
	
	//			  키   ,  값
	private Map<String, NameMaker> makeMap;	// Map 선언.
	
	public NameUI()		// 생성자 
	{
		scanner = new Scanner(System.in);	
		
		
		
		makeMap = new HashMap<>();				// Map 정의.
		
		makeMap.put("1", new IndianNameMaker());

	//	makeMap2.put("3", new MyNameMaker());	
			
	}

	public void makeName() 
	{	
		
		System.out.println("1. Indian, 2......");
		NameMaker maker = makeMap.get(scanner.nextLine());
		
		System.out.println("First data : ");
		String first = maker.getFirst(scanner.nextLine());
		
		System.out.println("Middle data : ");
		String middle = maker.getMiddle(scanner.nextLine());
		
		System.out.println("Last data : ");
		String last = maker.getLast(scanner.nextLine());

		System.out.println(first+middle+last);	
	}
	
	public static void main(String[] args) {
		new NameUI().makeName();
	}

}
