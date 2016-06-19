package Ceaser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Decoding {
	
	Map<Character, Character> ceaserMap;
		
		public Decoding() 
		{
			ceaserMap = new HashMap<>();		
			
			for(int i = 97; i < 123; i++)
			{
				if( i == 65)
				{
					ceaserMap.put((char)i, (char)(120));
					continue;
				}
				
				if( i == 66)
				{
					ceaserMap.put((char)i, (char)(121));
					continue;
				}
				
				if( i == 67)
				{
					ceaserMap.put((char)i, (char)(122));
					continue;
				}
				
				ceaserMap.put((char)i, (char)(i-3));
			}
		}	
}




class Decoding_Play
{
	void play() throws FileNotFoundException
	{
		InputStream in = new FileInputStream("c:\\zzz\\article.txt");
		Scanner scanner = new Scanner(in);	//���� ���� �غ� �Ϸ�(1)
	
		String str = scanner.nextLine();
		str 	   = str.toLowerCase();	

		char[] charArray = str.toCharArray();
		
		Decoding cn = new Decoding();
		
		System.out.println();
		System.out.println("Start Decording");
		
		for( int i =0; i < charArray.length; i++)
		{
			if(cn.ceaserMap.get(charArray[i]) == null)
			{
				System.out.print(charArray[i]);
				continue;
			}
			
			System.out.print(cn.ceaserMap.get(charArray[i]));
		}	
	}
}